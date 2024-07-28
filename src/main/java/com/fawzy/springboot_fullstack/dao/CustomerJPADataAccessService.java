package com.fawzy.springboot_fullstack.dao;

import com.fawzy.springboot_fullstack.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerJPADataAccessService implements CustomerDao {

    @Autowired
    private CustomerRepositoryJPA repository;

    @Override
    public void insert(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void update(Customer c) {
        repository.save(c);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsCustomerWithEmail(String email) {

        return repository.existsCustomerByEmail(email);
    }

    @Override
    public boolean existsCustomerWithId(Integer id) {
        return repository.existsCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerById(int id) {
        return repository.findById(id);
    }
}
