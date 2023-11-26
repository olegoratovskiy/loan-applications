package com.example.loanapplications.entity;

import com.example.loanapplications.enums.FileType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "file")
public class FileEntity {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "file_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private Long id;
    @Column(name = "type")
    private FileType type;
    @Lob
    @Column(name = "content")
    private byte[] content;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "application_id")
    private ApplicationEntity application;
}
