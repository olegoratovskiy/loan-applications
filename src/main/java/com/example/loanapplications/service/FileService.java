package com.example.loanapplications.service;

import com.example.loanapplications.dal.ApplicationDao;
import com.example.loanapplications.dal.FileDao;
import com.example.loanapplications.entity.FileEntity;
import com.example.loanapplications.enums.FileType;
import com.example.loanapplications.mapper.FileEntityMapper;
import com.example.loanapplications.model.File;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileDao fileDao;
    private final ApplicationDao applicationDao;
    private final FileEntityMapper mapper;

    public FileService(FileDao fileDao, ApplicationDao applicationDao, FileEntityMapper mapper) {
        this.fileDao = fileDao;
        this.applicationDao = applicationDao;
        this.mapper = mapper;
    }

    @Transactional
    public List<File> getFiles(long applicationId) {
        return fileDao.findAllByApplicationId(applicationId).stream()
                .map(mapper::entityToModel)
                .toList();
    }

    public Long addFile(long applicationId, String title, String type, byte[] file) {
        var application = applicationDao.findById(applicationId).orElseThrow();

        FileEntity fileEntity = new FileEntity();
        fileEntity.setContent(file);
        fileEntity.setApplication(application);
        fileEntity.setType(FileType.valueOf(type));
        fileEntity.setTitle(title);
        fileEntity = fileDao.save(fileEntity);
        application.getFiles().add(fileEntity);

        return fileEntity.getId();
    }

}
