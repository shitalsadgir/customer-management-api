package com.microservice.customermanagementapi.service;

import com.microservice.customermanagementapi.bean.Customer;
import com.microservice.customermanagementapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private static List<Customer> customers=new ArrayList<>();
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findOne(Long id){
        return customerRepository.findById(id);
    }
    public void DeleteOne(Long id){
         customerRepository.deleteById(id);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomerOne(Customer CustomerDetails, Long customerId) {
        Customer customer1 = customerRepository.findById(customerId).orElseThrow();

        customer1.setName(CustomerDetails.getName());
        customer1.setAge(CustomerDetails.getAge());
        customer1.setCity(CustomerDetails.getCity());
        customer1.setSalary(CustomerDetails.getSalary());
        customer1.setState(CustomerDetails.getState());
         customerRepository.save(customer1);

    }
}
