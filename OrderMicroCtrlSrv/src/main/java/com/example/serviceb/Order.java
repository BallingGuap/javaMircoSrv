package com.example.serviceb;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Order {
    private Long id;
    private String name;
    private Date start_date;
}
