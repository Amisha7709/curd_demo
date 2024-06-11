package com.curd.example.service.implement;

import com.curd.example.dto.CustomerDto;
import com.curd.example.entity.CustomerDemo;
import com.curd.example.repository.CustomerRepository;
import com.curd.example.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public CustomerDemo createCustomer(CustomerDto customerDto) {
        return customerRepository.save(getCustomerDemo(customerDto));

    }


    @Override
    public CustomerDemo update(Long id, CustomerDto customerDto) {
        customerRepository.findById(id);
        return customerRepository.save(getCustomerDemo(customerDto));
    }

    @Override
    public Optional<CustomerDemo> getById(Long id) {      //Optional used as a return type
        return  customerRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        customerRepository.deleteById(id);
        return "Delete Data Successfully";
    }

    @Override
    public CustomerDemo getByEmail(String email) {
        return  customerRepository.getByEmail(email);
    }

    @Override
    public CustomerDemo getByName(String name) {
        return customerRepository.getByName(name);
    }

    @Override
    public List<CustomerDemo> getAll() {
        return customerRepository.getAll();
    }

    private CustomerDemo getCustomerDemo(CustomerDto customerDto) {
        CustomerDemo customer = new CustomerDemo();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setAddress(customerDto.getAddress());
        return customer;
    }

}
