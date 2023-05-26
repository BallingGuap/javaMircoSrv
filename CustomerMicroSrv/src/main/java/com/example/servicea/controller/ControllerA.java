package com.example.servicea.controller;

import com.example.servicea.model.Customer;
import com.example.servicea.repo.CustomerRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Customer")
public class ControllerA {

    private final CustomerRepo repo;

    public ControllerA(CustomerRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    public Customer getEntityAById(@PathVariable Long id){
        return repo.findById(id).get();
    }
}
