package com.fawzy.springboot_fullstack.dao;

import com.fawzy.springboot_fullstack.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDao {
    @Override
    public void insert(Customer customer) {

    }

    @Override
    public void update(Customer customer, int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.of();
    }

    @Override
    public Optional<Customer> selectCustomerById(int id) {
        return Optional.empty();
    }
}
