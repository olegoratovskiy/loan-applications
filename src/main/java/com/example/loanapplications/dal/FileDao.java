package com.example.loanapplications.dal;

import com.example.loanapplications.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDao extends JpaRepository<FileEntity, Long> {
    List<FileEntity> findAllByApplicationId(long applicationId);
}
