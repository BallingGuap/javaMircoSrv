package com.example.servicec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient customerClient(){
        return WebClient.create("http://localhost:8081/api/v1/Customers/");
    }
    @Bean
    public WebClient orderClient(){
        return WebClient.create("http://localhost:8082/api/v1/Orders/");
    }
}
