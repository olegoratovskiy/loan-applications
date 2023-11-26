package com.example.loanapplications.dal;

import com.example.loanapplications.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationDao extends JpaRepository<ApplicationEntity, Long> {
}
