package com.example.hrdemo.data.dbmodel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name = "resume")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resume {

    @Id
    private UUID id;
    @Lob
    private byte[] content;
    private String type;
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
