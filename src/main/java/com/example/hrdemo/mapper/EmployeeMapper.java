package com.example.hrdemo.mapper;

import com.example.hrdemo.data.dbmodel.Employee;
import com.example.hrdemo.data.payload.request.CreateEmployeeRequestDto;
import com.example.hrdemo.data.payload.response.ResponseEmployeeDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmployeeMapper {

    public Employee toEmployeeFromCreateEmployeeRequestDto(CreateEmployeeRequestDto createEmployeeRequestDto) {
        if (createEmployeeRequestDto == null) {
            return null;
        } else {
            return Employee.builder()
                    .id(UUID.randomUUID())
                    .name(createEmployeeRequestDto.getName())
                    .lastName(createEmployeeRequestDto.getLastName())
                    .department(createEmployeeRequestDto.getDepartment())
                    .title(createEmployeeRequestDto.getTitle())
                    .salary(createEmployeeRequestDto.getSalary())
                    .birthDate(createEmployeeRequestDto.getBirthDate())
                    .identificationNumber(createEmployeeRequestDto.getIdentificationNumber())
                    .dateOfParticipation(createEmployeeRequestDto.getDateOfParticipation())
                    .email(createEmployeeRequestDto.getEmail())
                    .build();
        }
    }

    public ResponseEmployeeDto toResponseEmployeeDtoFromCreateEmployeeRequestDto(CreateEmployeeRequestDto createEmployeeRequestDto) {
        if (createEmployeeRequestDto == null) {
            return null;
        } else {
            return ResponseEmployeeDto.builder()
                    .name(createEmployeeRequestDto.getName())
                    .lastName(createEmployeeRequestDto.getLastName())
                    .department(createEmployeeRequestDto.getDepartment())
                    .title(createEmployeeRequestDto.getTitle())
                    .salary(createEmployeeRequestDto.getSalary())
                    .birthDate(createEmployeeRequestDto.getBirthDate())
                    .identificationNumber(createEmployeeRequestDto.getIdentificationNumber())
                    .dateOfParticipation(createEmployeeRequestDto.getDateOfParticipation())
                    .email(createEmployeeRequestDto.getEmail())
                    .build();
        }
    }

    public ResponseEmployeeDto toResponseEmployeeDtoFromEmployee(Employee employee) {
        if (employee == null) {
            return null;
        } else {
            return ResponseEmployeeDto.builder()
                    .name(employee.getName())
                    .lastName(employee.getLastName())
                    .department(employee.getDepartment())
                    .title(employee.getTitle())
                    .salary(employee.getSalary())
                    .birthDate(employee.getBirthDate())
                    .identificationNumber(employee.getIdentificationNumber())
                    .dateOfParticipation(employee.getDateOfParticipation())
                    .email(employee.getEmail())
                    .build();
        }
    }

}
