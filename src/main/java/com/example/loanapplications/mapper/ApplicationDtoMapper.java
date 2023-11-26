package com.example.loanapplications.mapper;

import com.example.loanapplications.dto.response.ApplicationResponseDto;
import com.example.loanapplications.enums.ApplicationStatus;
import com.example.loanapplications.model.Application;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ApplicationDtoMapper {
    public ApplicationResponseDto modelToResponse(Application model) {
        return new ApplicationResponseDto(
               model.id(),
               model.status(),
               model.fullName(),
               model.changedAt()
        );
    }

    public Application requestToModel(String status, String fullName) {
        return new Application(
                null,
                ApplicationStatus.valueOf(status),
                fullName,
                Instant.now()
        );
    }
}
