package com.example.loanapplications.mapper;

import com.example.loanapplications.entity.FileEntity;
import com.example.loanapplications.model.File;
import org.springframework.stereotype.Component;

@Component
public class FileEntityMapper {

    public File entityToModel(FileEntity entity) {
        return new File(entity.getId(), entity.getType(), entity.getContent(), entity.getTitle());
    }

//    public FileEntity modelToEntity()/**/ {
//        return new FileEntity(model.id(), model.);
//    }
}
