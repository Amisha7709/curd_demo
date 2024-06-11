package com.curd.example.service;


import com.curd.example.dto.CustomerDto;
import com.curd.example.entity.CustomerDemo;
import com.curd.example.repository.CustomerRepository;
import com.curd.example.service.implement.CustomerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
public class ServiceTest {

    @InjectMocks
    CustomerImpl customerService;

    @Mock
    CustomerRepository customerRepository;

    CustomerDemo customerDemo;

    CustomerDto customerDto;

    @BeforeEach
    public void setUp(){
        customerDemo = new CustomerDemo();
        customerDemo.setId(1L);
        customerDemo.setName("Sana");
        customerDemo.setMobileNumber(565567576);
        customerDemo.setEmail("sana@gmail.com");
        customerDemo.setAddress("Nagpur");


        customerDto = new CustomerDto();
        customerDto.setId(1L);
        customerDto.setName("Sana");
        customerDto.setMobileNumber(565567576);
        customerDto.setEmail("sana@gmail.com");
        customerDto.setAddress("Nagpur");
    }

    @Test
    void createCustomer(){
        Mockito.when(customerRepository.save(ArgumentMatchers.any(CustomerDemo.class))).thenReturn(customerDemo);
        assertEquals(customerDemo, customerService.createCustomer(customerDto));
    }

    @Test
    void update(){
        Mockito.when(customerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(customerDemo));
        assertNotEquals(customerDemo, customerService.update(customerDemo.getId(),customerDto));
    }

    @Test
    void deleteById(){
        Mockito.when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customerDemo));
        assertEquals("Delete Data Successfully", customerService.deleteById(anyLong()));
    }

    @Test
    void getById(){
        Mockito.when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customerDemo));
        assertEquals(Optional.of(customerDemo),customerService.getById(anyLong()));
    }

    @Test
    void getByEmail(){
        Mockito.when(customerRepository.getByEmail(anyString())).thenReturn(customerDemo);
        assertEquals(customerDemo, customerService.getByEmail(anyString()));
    }

    @Test
    void getByName(){
        Mockito.when(customerRepository.getByName(anyString())).thenReturn(customerDemo);
        assertEquals(customerDemo ,customerService.getByName(anyString()));
    }

    @Test
    void getAll(){
        List<CustomerDemo> customerDemoList = new ArrayList<>();
        customerDemoList.add(customerDemo);
        Mockito.when(customerRepository.getAll()).thenReturn(customerDemoList);
        assertEquals(customerDemoList ,customerService.getAll());
    }

}
