package com.example.hrdemo.repositories;

import com.example.hrdemo.data.dbmodel.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
