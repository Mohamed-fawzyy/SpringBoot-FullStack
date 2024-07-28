package com.fawzy.springboot_fullstack.dao;

import com.fawzy.springboot_fullstack.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoryJPA extends JpaRepository<Customer, Integer> {

    boolean existsCustomerByEmail(String email);
    boolean existsCustomerById(Integer id);

}
