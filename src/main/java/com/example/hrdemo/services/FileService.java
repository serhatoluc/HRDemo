package com.example.hrdemo.services;

import com.example.hrdemo.data.dbmodel.Resume;
import com.example.hrdemo.repositories.ResumeRepository;
import com.example.hrdemo.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private final ResumeRepository resumeRepository;
    @Transactional
    public byte[] getResumeByEmployeeId(UUID employeeId) {
        Optional<Resume> resume = resumeRepository.findByEmployeeId(employeeId);

        if (resume.isPresent()){
            return FileUtils.decompressFile(resume.get().getContent());
        }else {
            throw new RuntimeException("Arama yaptığınız kullanıcının dosya bilgisine ulaşılamadı.");
        }
    }
}
