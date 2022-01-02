package com.microservice.customermanagementapi.controller;

import com.microservice.customermanagementapi.bean.Customer;
import com.microservice.customermanagementapi.repository.CustomerRepository;
import com.microservice.customermanagementapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    public CustomerService customerService;
    @Autowired
    public CustomerRepository customerRepository;

    @GetMapping("/display")
    public String DisplayMessage() {
        return "Hello Threre!";
    }

    @GetMapping("/customers")
    public List<Customer> retriveAll() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> retriveOneCustomer(@PathVariable Long id) {
        return customerService.findOne(id);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteOneCustomer(@PathVariable Long id) {
        customerService.DeleteOne(id);
    }

    @PostMapping("/customers")
    public void createOneCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public void updateCustomer(@PathVariable(value = "id") Long customerId,
                               @RequestBody Customer customerDetails) throws ConfigDataResourceNotFoundException {
        customerService.updateCustomerOne(customerDetails, customerId);
    }
}