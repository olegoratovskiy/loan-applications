package com.example.loanapplications.service;

import com.example.loanapplications.dal.ApplicationDao;
import com.example.loanapplications.dal.FileDao;
import com.example.loanapplications.mapper.ApplicationEntityMapper;
import com.example.loanapplications.model.Application;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ApplicationService {

    private final ApplicationDao applicationDao;
    private final ApplicationEntityMapper mapper;

    public ApplicationService(ApplicationDao applicationDao, ApplicationEntityMapper mapper) {
        this.applicationDao = applicationDao;
        this.mapper = mapper;
    }

    public List<Application> getApplications() {
        return applicationDao.findAll().stream()
                .map(mapper::entityToModel)
                .toList();
    }

    public Application getApplication(long applicationId) {
        return applicationDao.findById(applicationId)
                .map(mapper::entityToModel)
                .orElseThrow(NoSuchElementException::new);
    }

    public Long createApplication(Application model) {
        return applicationDao.save(mapper.modelToEntity(model, List.of())).getId();
    }
}
