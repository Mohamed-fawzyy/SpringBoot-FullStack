package com.fawzy.springboot_fullstack.controller;

import com.fawzy.springboot_fullstack.Service.CustomerService;
import com.fawzy.springboot_fullstack.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public List<Customer> getCustomerById(@PathVariable int id) {
        return customerService.getAllCustomers();
    }

    @PutMapping(path = "/{id}")
    public List<Customer> updateCustomer(@PathVariable int id) {
        return customerService.getAllCustomers();
    }

    @DeleteMapping(params = "/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }

}
