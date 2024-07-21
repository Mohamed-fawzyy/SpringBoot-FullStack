package com.fawzy.springboot_fullstack.dao;

import com.fawzy.springboot_fullstack.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    void insert(Customer customer);
    void update(Customer customer, int id);
    void delete(int id);

    List<Customer> getAllCustomers();
    Optional<Customer> selectCustomerById(int id);
}
