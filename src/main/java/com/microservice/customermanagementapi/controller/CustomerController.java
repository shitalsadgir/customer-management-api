package com.microservice.customermanagementapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @GetMapping("/display")
    public String DisplayMessage(){
        return "Hello Threre!";
    }
}
