package com.example.loanapplications.controller;

import com.example.loanapplications.dto.response.FileResponseDto;
import com.example.loanapplications.mapper.FileDtoMapper;
import com.example.loanapplications.service.FileService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;
    private final FileDtoMapper mapper;

    public FileController(FileService fileService, FileDtoMapper mapper) {
        this.fileService = fileService;
        this.mapper = mapper;
    }

    @GetMapping("/{applicationId}")
    public List<FileResponseDto> getFiles(@PathVariable long applicationId) {
        return fileService.getFiles(applicationId).stream().map(mapper::modelToResponse).toList();
    }

    @PostMapping("/add")
    public Long addFile(
            @RequestParam long applicationId,
            @RequestParam String title,
            @RequestPart MultipartFile file,
            @RequestParam(defaultValue = "PDF") String type
    ) throws IOException {
        return fileService.addFile(applicationId, title, type, file.getBytes());
    }
}
