package com.curd.example.controller;

import com.curd.example.dto.CustomerDto;
import com.curd.example.entity.CustomerDemo;
import com.curd.example.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
public class ControllerTest {

    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerService customerService;

    CustomerDemo customerDemo;

    CustomerDto customerDto;


    @BeforeEach
    public void initEach() {
        customerDto = new CustomerDto();
        customerDto.setId(1L);
        customerDto.setName("Amisha");
        customerDto.setMobileNumber(565567576);
        customerDto.setEmail("amisha@gmail.com");
        customerDto.setAddress("Nagpur");

        customerDemo = new CustomerDemo();
        customerDemo.setId(1L);
        customerDemo.setName("Amisha");
        customerDemo.setMobileNumber(565567576);
        customerDemo.setEmail("amisha@gmail.com");
        customerDemo.setAddress("Nagpur");
    }

    @Test
    void customerSave() {
        Mockito.when(customerService.createCustomer(customerDto)).thenReturn(customerDemo);
        assertEquals(customerDemo, customerController.customerSave(customerDto).getBody());

    }

    @Test
    void update() {
        Mockito.when(customerService.update(1L, customerDto)).thenReturn(customerDemo);
        assertEquals(customerDemo, customerController.update(1L, customerDto).getBody());
    }

    @Test
    void getById() {
        Mockito.when(customerService.getById(anyLong())).thenReturn(Optional.of(customerDemo));
        assertEquals(Optional.of(customerDemo), customerController.getById(anyLong()).getBody());
    }

    @Test
    void deleteById() {
        Mockito.when(customerService.deleteById(anyLong())).thenReturn("Delete Data Successfully");
        assertEquals("Delete Data Successfully", customerController.deleteById(anyLong()).getBody());
    }

    @Test
    void getByEmail() {
        Mockito.when(customerService.getByEmail(anyString())).thenReturn(customerDemo);
        assertEquals(customerDemo, customerController.getByEmail(anyString()).getBody());
    }

    @Test
    void getByName() {
        Mockito.when(customerService.getByName(anyString())).thenReturn(customerDemo);
        assertEquals(customerDemo, customerController.getByName(anyString()).getBody());
    }

    @Test
    void getAll(){
        List<CustomerDemo> customerDemoList = new ArrayList<>();
        customerDemoList.add(customerDemo);
        Mockito.when(customerService.getAll()).thenReturn(customerDemoList);
        assertEquals(customerDemoList, customerService.getAll());
    }

}
