package com.fawzy.springboot_fullstack.dao;

import com.fawzy.springboot_fullstack.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoryJPA extends JpaRepository<Customer, Integer> {

    boolean existsCustomerByEmail(String email);
    boolean existsCustomerByName(String name);

    boolean existsCustomerById(Integer id);
    boolean existsCustomerByAge(Integer id);
}
