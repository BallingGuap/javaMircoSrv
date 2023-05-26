package com.example.servicec.controller;
import com.example.servicec.model.Customer;
import com.example.servicec.model.Order;
import com.example.servicec.service.MainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class Controller {
    private final MainService service;

    public Controller(MainService cService) {
        this.service = cService;
    }

    @GetMapping("/AppendCustomer/{id}")
    public ResponseEntity<String> getCustomer(@RequestParam Long customerId, @RequestBody Order order){
        var customer = service.getCustomer(customerId);
        try {
            customer.ifPresentOrElse(c ->
                    {
                        service.appendOrder(order)
                                .ifPresentOrElse(e -> {
                                    throw e;
                                }, null);
                    }
                    , () -> {
                        throw new RuntimeException("Finding was failed!!");
                    });
        }
        catch (final RuntimeException e)
        {
            return  new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
               return ResponseEntity.ok("Append Successes!");

    }


}
