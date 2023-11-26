package com.example.loanapplications.model;

import com.example.loanapplications.enums.FileType;

public record File(
        Long id,
        FileType type,
        byte[] content,
        String title
) {
}
