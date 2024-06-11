package com.curd.example.repository;

import com.curd.example.entity.CustomerDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerDemo,Long> {

         CustomerDemo getByEmail(String email);
         CustomerDemo getByName(String name);

         List<CustomerDemo> getAll();
}
