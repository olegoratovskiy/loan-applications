package com.example.loanapplications.controller;

import com.example.loanapplications.dto.response.ApplicationResponseDto;
import com.example.loanapplications.mapper.ApplicationDtoMapper;
import com.example.loanapplications.service.ApplicationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationDtoMapper mapper;

    public ApplicationController(
            ApplicationService applicationService,
            ApplicationDtoMapper mapper
    ) {
        this.applicationService = applicationService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ApplicationResponseDto> getApplications() {
        return applicationService.getApplications().stream()
                .map(mapper::modelToResponse)
                .toList();
    }

    @GetMapping("/{applicationId}")
    public ApplicationResponseDto getApplication(@PathVariable long applicationId) {
        return mapper.modelToResponse(applicationService.getApplication(applicationId));
    }

    @PostMapping("/create")
    public Long createApplication(
            @RequestParam String status,
            @RequestParam String fullName
    ) {
        return applicationService.createApplication(mapper.requestToModel(status, fullName));
    }
}
