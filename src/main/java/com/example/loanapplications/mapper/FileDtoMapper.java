package com.example.loanapplications.mapper;

import com.example.loanapplications.dto.response.FileResponseDto;
import com.example.loanapplications.model.File;
import org.springframework.stereotype.Component;

@Component
public class FileDtoMapper {
    public FileResponseDto modelToResponse(File model) {
        return new FileResponseDto(model.id(), model.type(), model.content(), model.title());
    }
}
