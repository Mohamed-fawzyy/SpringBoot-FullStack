package com.fawzy.springboot_fullstack.dao;

import com.fawzy.springboot_fullstack.exceptions.RequestValidationException;
import com.fawzy.springboot_fullstack.model.Customer;
import com.fawzy.springboot_fullstack.model.CustomerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class CustomerRepoJdbcImp implements CustomerRepositoryJDBC{

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    public CustomerRepoJdbcImp(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    @Override
    public void insert(Customer customer) {

        String sql = "insert into customer values(?,?,?)";
        int res = jdbcTemplate.update(sql, customer.getAge(), customer.getName(), customer.getEmail());
        if (res != 1) {
            throw new RequestValidationException("Error inserting customer");
        }
    }

    @Override
    public void update(Customer customer) {

        String sql = """
               update customer () """;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    @Override
    public boolean existsCustomerWithEmail(String email) {
        return false;
    }

    @Override
    public boolean existsCustomerWithId(int id) {
        return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "select * from customer";
        return jdbcTemplate.query(sql, customerRowMapper);
    }

    @Override
    public Optional<Customer> selectCustomerById(int id) {

        String sql = "select * from customer where id=?";
        return jdbcTemplate.query(sql, customerRowMapper)
                .stream().findFirst();
    }
}
