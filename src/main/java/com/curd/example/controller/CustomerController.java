package com.curd.example.controller;

import com.curd.example.dto.CustomerDto;
import com.curd.example.entity.CustomerDemo;
import com.curd.example.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerDemo> customerSave(@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.createCustomer(customerDto),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDemo>update(@PathVariable Long id,@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.update(id,customerDto),HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<CustomerDemo>>getById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String>deleteById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.deleteById(id),HttpStatus.OK);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<CustomerDemo> getByEmail(@PathVariable String email){
        return new ResponseEntity<>(customerService.getByEmail(email),HttpStatus.OK);
    }

    @GetMapping("getByName/{name}")
    public ResponseEntity<CustomerDemo> getByName(@PathVariable String name){
        return new ResponseEntity<>(customerService.getByName(name),HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<CustomerDemo>> getAll(){
        return new ResponseEntity<>(customerService.getAll(),HttpStatus.OK);
    }

}
