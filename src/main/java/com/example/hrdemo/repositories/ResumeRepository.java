package com.example.hrdemo.repositories;

import com.example.hrdemo.data.dbmodel.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ResumeRepository extends JpaRepository<Resume, UUID> {

    Optional<Resume> findByEmployeeId (UUID employeeId);
}
