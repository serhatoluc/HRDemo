package com.example.hrdemo.mapper;

import com.example.hrdemo.data.dbmodel.Address;
import com.example.hrdemo.data.payload.request.CreateEmployeeRequestDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddressMapper {

    public Address toAddressFromCreateEmployeeRequestDto(CreateEmployeeRequestDto createEmployeeRequestDto) {
        if (createEmployeeRequestDto == null) {
            return null;
        } else {
            return Address.builder()
                    .addressLine(createEmployeeRequestDto.getAddressLine())
                    .id(UUID.randomUUID())
                    .country(createEmployeeRequestDto.getCountry())
                    .postalCode(createEmployeeRequestDto.getPostalCode())
                    .phoneNumber(createEmployeeRequestDto.getPhoneNumber())
                    .city(createEmployeeRequestDto.getCity())
                    .build();
        }
    }
}
