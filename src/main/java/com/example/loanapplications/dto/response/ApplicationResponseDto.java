package com.example.loanapplications.dto.response;

import com.example.loanapplications.enums.ApplicationStatus;

import java.time.Instant;

public record ApplicationResponseDto(
        Long id,
        ApplicationStatus status,
        String fullName,
        Instant changedAt
) {
}
