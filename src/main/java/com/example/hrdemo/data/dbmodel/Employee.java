package com.example.hrdemo.data.dbmodel;

import com.example.hrdemo.data.enums.Department;
import com.example.hrdemo.data.enums.Title;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    private UUID id;

    private String name;
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

    @ToString.Exclude
    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @ToString.Exclude
    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Resume resume;
}