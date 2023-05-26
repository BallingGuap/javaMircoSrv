package com.example.servicec.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Customer {
    private Long id;
    private String name;
    private int age;
}
