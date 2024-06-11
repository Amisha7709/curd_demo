package com.curd.example.service;

import com.curd.example.dto.CustomerDto;
import com.curd.example.entity.CustomerDemo;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    CustomerDemo createCustomer(CustomerDto customerDto);

    CustomerDemo update(Long id, CustomerDto customerDto);

    Optional<CustomerDemo> getById(Long id);

    String deleteById(Long id);

    CustomerDemo getByEmail(String email);

    CustomerDemo getByName(String name);

    List<CustomerDemo> getAll();
}
