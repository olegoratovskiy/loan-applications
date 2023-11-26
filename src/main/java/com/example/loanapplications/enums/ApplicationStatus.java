package com.example.loanapplications.enums;

public enum ApplicationStatus {
    NEW, // Новая
    IN_PROGRESS, // В работе
    ADDITIONAL_INFORMATION_REQUEST, // Дозапрос информации
    PENDING, // На доработке
    FINALIZED // Завершена (не отображается у андеррайтера)
}
