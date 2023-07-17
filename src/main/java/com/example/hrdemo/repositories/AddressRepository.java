package com.example.hrdemo.repositories;

import com.example.hrdemo.data.dbmodel.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
