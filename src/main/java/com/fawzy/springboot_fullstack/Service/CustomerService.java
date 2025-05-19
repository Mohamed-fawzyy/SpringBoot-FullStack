package com.fawzy.springboot_fullstack.Service;

import com.fawzy.springboot_fullstack.dao.CustomerDao;
import com.fawzy.springboot_fullstack.exceptions.DuplicateResourceException;
import com.fawzy.springboot_fullstack.exceptions.RequestValidationException;
import com.fawzy.springboot_fullstack.exceptions.ResourceNotFoundException;
import com.fawzy.springboot_fullstack.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void updateCustomer(CustomerUpdateRequest c, int id) {

        if (!customerDao.existsCustomerWithId(id)) {
            throw new ResourceNotFoundException("Customer with id " + id + " not found");
        } else {

            Customer oldCustomerData = getCustomerById(id);
            boolean flag = false;

            if (c.email() != null && !c.email().equals(oldCustomerData.getEmail())) {

                if (customerDao.existsCustomerWithEmail(c.email())) {
                    throw new DuplicateResourceException("This email address already exists.");
                }
                oldCustomerData.setEmail(c.email());
                flag = true;
            }

            if (c.name() != null && !c.name().equals(oldCustomerData.getName())) {
                oldCustomerData.setName(c.name());
                flag = true;
            }

            if (c.age() != null && !c.age().equals(oldCustomerData.getAge())) {
                oldCustomerData.setAge(c.age());
                flag = true;
            }

            if (!flag) {
                throw new RequestValidationException("No changes, this data already exists");
            }
            customerDao.update(oldCustomerData);
        }
    }

    public void deleteCustomer(int id) {

        if (!customerDao.existsCustomerWithId(id)) {
            throw new ResourceNotFoundException("Customer with id " + id + " not found");
        }
        customerDao.delete(id);
    }


    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id [%s] not found".formatted(id)));
    }

    public void customerRegistration(CustomerRegistrationRequest c) {

        if (customerDao.existsCustomerWithEmail(c.email())) {
            throw new DuplicateResourceException("This email address already exists");
        } else {
            customerDao.insert(
                    new Customer(
                            c.name(),
                            c.email(),
                            c.age()
                    )
            );
        }
    }

}
