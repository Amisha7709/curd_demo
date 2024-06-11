package com.curd.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerDto {

        private Long id;
        private String name;
        private String address;
        private String email;
        private int mobileNumber;
}
