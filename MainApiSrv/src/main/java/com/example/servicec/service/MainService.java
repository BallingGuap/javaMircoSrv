package com.example.servicec.service;

import com.example.servicec.model.Customer;
import com.example.servicec.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class MainService {
    private final WebClient customerClient;
    private final WebClient orderClient;
    public MainService(WebClient customerClient, WebClient orderClient) {
        this.customerClient = customerClient;
        this.orderClient = orderClient;
    }

    public Optional<Customer> getCustomer(Long id) {
        return Optional.ofNullable(customerClient.get().uri(uriBuilder -> uriBuilder.path(id.toString()).build())
                .retrieve()
                .bodyToMono(Customer.class)
                .block());
    }

    public Optional<RuntimeException> appendOrder(Order order) {
         return Optional.ofNullable(orderClient.get().uri(uriBuilder -> uriBuilder.queryParam("Order", order).build())
                .retrieve()
                .bodyToMono(RuntimeException.class)
                .block());
    }
}
