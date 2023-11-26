package com.example.loanapplications.mapper;

import com.example.loanapplications.entity.ApplicationEntity;
import com.example.loanapplications.entity.FileEntity;
import com.example.loanapplications.model.Application;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationEntityMapper {
    public Application entityToModel(ApplicationEntity entity) {
        return new Application(
                entity.getId(),
                entity.getStatus(),
                entity.getFullName(),
                entity.getChangedAt()
        );
    }

    public ApplicationEntity modelToEntity(Application model, List<FileEntity> files) {
        var applicationEntity = new ApplicationEntity();
        applicationEntity.setStatus(model.status());
        applicationEntity.setFullName(model.fullName());
        applicationEntity.setStatus(model.status());
        applicationEntity.setChangedAt(model.changedAt());
        applicationEntity.setFiles(files);
        return applicationEntity;
    }
}
