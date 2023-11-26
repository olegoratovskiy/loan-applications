package com.example.loanapplications.model;

import com.example.loanapplications.enums.ApplicationStatus;

import java.time.Instant;

public record Application(
        Long id,
        ApplicationStatus status,
        String fullName,
        Instant changedAt
) {
}
