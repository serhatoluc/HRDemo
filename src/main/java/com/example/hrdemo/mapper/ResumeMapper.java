package com.example.hrdemo.mapper;

import com.example.hrdemo.data.dbmodel.Resume;
import com.example.hrdemo.utils.FileUtils;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
public class ResumeMapper {

    public Resume toResumeFromMultiPart(MultipartFile file) throws IOException {
        return Resume.builder()
                .name(file.getName())
                .id(UUID.randomUUID())
                .content(FileUtils.compressFile(file.getBytes()))
                .type(file.getContentType())
                .build();
    }
}
