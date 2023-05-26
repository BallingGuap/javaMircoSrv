package com.example.serviceb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Order")
public class ControllerB {

    private final OrderRepo repo;

    public ControllerB(OrderRepo repo) {
        this.repo = repo;
    }


    public RuntimeException getEntityAById(@RequestBody Order order){
        try{
            repo.save(order);
        }
        catch (final RuntimeException e) {
            return e;
        }
        return  null;
    }
}
