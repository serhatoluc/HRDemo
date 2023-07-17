package com.example.hrdemo.controller;

import com.example.hrdemo.data.payload.request.CreateEmployeeRequestDto;
import com.example.hrdemo.data.payload.response.ResponseEmployeeDto;
import com.example.hrdemo.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ResponseEmployeeDto> createEmployeeDto(@Valid @RequestPart("createEmployeeRequestDto") CreateEmployeeRequestDto createEmployeeRequestDto,
                                                                 @RequestPart("resume") MultipartFile resume) throws IOException, SQLException {
        return ResponseEntity.ok(employeeService.createEmployee(createEmployeeRequestDto, resume));
    }

    @PostMapping("/createFile")
    public ResponseEntity<String> denme(@RequestParam(value = "resume") MultipartFile resume) throws IOException {
        return ResponseEntity.ok(employeeService.createFile(resume));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<ResponseEmployeeDto> getEmployeeById(@PathVariable UUID employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping
    public ResponseEntity<List<ResponseEmployeeDto>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById (@PathVariable UUID employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

}
