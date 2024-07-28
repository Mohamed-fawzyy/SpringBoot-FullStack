package com.fawzy.springboot_fullstack.controller;

import com.fawzy.springboot_fullstack.Service.CustomerRegistrationRequest;
import com.fawzy.springboot_fullstack.Service.CustomerService;
import com.fawzy.springboot_fullstack.Service.CustomerUpdateRequest;
import com.fawzy.springboot_fullstack.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    @PostMapping
//    public void addCustomer(@NonNull @RequestBody Customer customer) {
//        customerService.addCustomer(customer);
//    }

    @PostMapping
    public void customerRegister(@NonNull @RequestBody CustomerRegistrationRequest customer) {
        customerService.customerRegistration(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping(path = "/{id}")
    public void updateCustomer(@PathVariable int id, @NonNull @RequestBody CustomerUpdateRequest customer) {
        customerService.updateCustomer(customer, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }

}
