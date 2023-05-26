package com.example.servicec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Order {
    private Long id;
    private String name;
    private Date start_date;
}
