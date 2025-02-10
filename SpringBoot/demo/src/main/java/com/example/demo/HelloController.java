package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Marks this class as a REST API
@RequestMapping("/api")  // Base URL: /api
public class HelloController {

    @GetMapping("/hello")  // API Endpoint: /api/hello
    public String sayHello() {
        return "👋 Hello from Spring Boot!";
    }
}
