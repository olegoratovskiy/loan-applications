package com.example.loanapplications.dto.response;

import com.example.loanapplications.enums.FileType;

public record FileResponseDto(
        Long id,
        FileType type,
        byte[] content,
        String title
) {
}
