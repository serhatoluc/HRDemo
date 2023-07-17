package com.example.hrdemo.data.payload.response;

import com.example.hrdemo.data.enums.Department;
import com.example.hrdemo.data.enums.Title;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseEmployeeDto {

    private String name;
    private Integer id;
    private String lastName;
    private String email;
    private Long identificationNumber;
    private BigDecimal salary;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate dateOfParticipation;
    @Enumerated
    private Title title;
    @Enumerated
    private Department department;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    private byte[] resume;


}
