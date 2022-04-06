package com.ksprogramming.employee;

import com.ksprogramming.customer.Customer;

import java.sql.Connection;
import java.util.List;

public class EmployeeService {
    private Connection connection;
    private EmployeeRepository employeeRepository;

    public EmployeeService(Connection connection) {
        this.connection = connection;
        employeeRepository = new EmployeeRepository(connection);
    }

    public Employee get(Integer id) {
        return employeeRepository.get(id);

    }

    public List<Employee> find(Employee employee) {
        return employeeRepository.find(employee);

    }

    public Integer create(Employee employee) {
        return employeeRepository.create(employee);
    }

    public void update(Integer id, Employee employee) {
        employeeRepository.update(id, employee);
    }

    public void remove(Integer id) {
        employeeRepository.remove(id);
    }
}
