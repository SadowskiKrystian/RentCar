package com.ksprogramming.customer;

import java.sql.Connection;
import java.util.List;

public class CustomerService {
    private Connection connection;
    private CustomerRepository customerRepository;


    public CustomerService(Connection connection) {
        this.connection = connection;
        customerRepository = new CustomerRepository(connection);
    }

    public Customer getId(Integer id) {
        return customerRepository.getId(id);

    }

    public List<Customer> find(Customer customer) {
        return customerRepository.find(customer);

    }

    public Integer create(Customer customer) {
        return customerRepository.create(customer);
    }

    public void update(Integer id, Customer customer) {
        customerRepository.update(id, customer);
    }

    public void remove(Integer id) {
        customerRepository.remove(id);
    }


}
