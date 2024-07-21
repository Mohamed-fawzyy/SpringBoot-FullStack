package com.fawzy.springboot_fullstack.Service;

import com.fawzy.springboot_fullstack.dao.CustomerDao;
import com.fawzy.springboot_fullstack.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        customerDao.insert(customer);
    }

    public void updateCustomer(Customer customer, int id) {
        customerDao.update(customer, id);
    }

    public void deleteCustomer(int id) {
        customerDao.delete(id);
    }


    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerDao.selectCustomerById(id);
    }

}
