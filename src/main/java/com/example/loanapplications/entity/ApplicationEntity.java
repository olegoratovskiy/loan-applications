package com.example.loanapplications.entity;

import com.example.loanapplications.enums.ApplicationStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "application")
public class ApplicationEntity {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "application_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private Long id;
    @Column(name = "status")
    private ApplicationStatus status;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "changed_at")
    private Instant changedAt;
    @OneToMany(mappedBy = "application", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<FileEntity> files;
}
