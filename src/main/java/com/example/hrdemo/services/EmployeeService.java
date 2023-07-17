package com.example.hrdemo.services;

import com.example.hrdemo.data.dbmodel.Address;
import com.example.hrdemo.data.dbmodel.Employee;
import com.example.hrdemo.data.dbmodel.Resume;
import com.example.hrdemo.data.payload.request.CreateEmployeeRequestDto;
import com.example.hrdemo.data.payload.response.ResponseEmployeeDto;
import com.example.hrdemo.mapper.AddressMapper;
import com.example.hrdemo.mapper.EmployeeMapper;
import com.example.hrdemo.mapper.ResumeMapper;
import com.example.hrdemo.repositories.AddressRepository;
import com.example.hrdemo.repositories.EmployeeRepository;
import com.example.hrdemo.repositories.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    //TODO: Bağımlılıkları azalmak için Resume ve Address için farklı servisler oluşturulup metodlar oradan çağırılabilir. Vakit darlığından dolayı yapamadım :)

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final ResumeRepository resumeRepository;
    private final EmployeeMapper employeeMapper;
    private final AddressMapper addressMapper;
    private final ResumeMapper resumeMapper;

    public ResponseEmployeeDto createEmployee(CreateEmployeeRequestDto createEmployeeRequestDto, MultipartFile resumeRequest) throws IOException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5436/HRDemo", "localpostgres", "localpostgressecret");
        connection.setAutoCommit(false);
        Employee employee = employeeMapper.toEmployeeFromCreateEmployeeRequestDto(createEmployeeRequestDto);
        Address address = addressMapper.toAddressFromCreateEmployeeRequestDto(createEmployeeRequestDto);
        Resume resume = resumeMapper.toResumeFromMultiPart(resumeRequest);
        address.setEmployee(employee);
        resume.setEmployee(employee);
        employeeRepository.save(employee);
        addressRepository.save(address);
        resumeRepository.save(resume);
        return employeeMapper.toResponseEmployeeDtoFromCreateEmployeeRequestDto(createEmployeeRequestDto);
    }

    public String createFile(MultipartFile resumeRequest) throws IOException {

        Resume resume = resumeMapper.toResumeFromMultiPart(resumeRequest);

        resumeRepository.save(resume);

        return "Başarılı";

    }

    public ResponseEmployeeDto getEmployeeById(UUID employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employeeMapper::toResponseEmployeeDtoFromEmployee)
                .orElseThrow(() -> new RuntimeException("Kullanici Bulunamadi"));
    }

    public List<ResponseEmployeeDto> getAllEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponseEmployeeDtoFromEmployee)
                .toList();
    }

    public void deleteEmployeeById(UUID employeeId) {
        if(employeeRepository.findById(employeeId).isPresent()){
            employeeRepository.deleteById(employeeId);
        }else
            throw new RuntimeException("Kullanici Bulunamiyor!");
    }
}
