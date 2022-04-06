package com.ksprogramming;

import com.ksprogramming.customer.Customer;
import com.ksprogramming.customer.CustomerService;
import com.ksprogramming.employee.Employee;
import com.ksprogramming.employee.EmployeeService;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver loaded");
        } catch (Exception ex) {
            System.out.println("Problem with driver");
            ex.printStackTrace();
        }
        Connection connection = null;

        try {
            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/RentCar?" +
                            "user=root&password=Krystianjava87pl&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            System.out.println("connected");
            CustomerService customerService = new CustomerService(connection);
            EmployeeService employeeService = new EmployeeService(connection);

            //employeeService.create(new Employee("Krystian", "Sadowski", "870411", "39", null, "Coronation Park", "Aughnacloy","Bt696aw"));
           //employeeService.update(1, new Employee("Krystian", "Sadowski", "870430", "39", "1", "Coronation Park", "Aughnacloy","Bt696aw"));
            employeeService.find(new Employee("Krystian", null, null, null, null, null, "Aughnacloy","Bt696aw")).stream().forEach(System.out::println);
            //System.out.println(customerService.get(2));

            //customerService.create(new Customer("P", null, null, "Alan", "Sadowski",
            //      "170406", "1", null, "Zmarlego Putina", "Aughnacloy", "BT696AW"));
            //customerService.update(3,new Customer("P", null, null, "Krystian", "Sadowski",
            //      "870411", "39", null, "Coronation Park", "Aughnacloy", "BT696AW"));
            //customerService.remove(3);
            //System.out.println(customerService.get(1));
            //customerService.find();
            customerService.find(new Customer(null,null,null,"Adam",null,
                    null,null,null,null,null, null)).stream()
                    .forEach(System.out::println);
            //System.out.println(customerService.create(new Customer("P", null, null, "Bogdan", "Kowalski", "697745", "11", "3", "Mickiewicza", "Elblag", "82-433")));
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            closeConnection(connection);
        }


    }

    private static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) {
            }

        }
    }

    private static void closeResultSet(ResultSet rs) {
        if (rs != null) {

            try {
                rs.close();
            } catch (SQLException sqlEx) {
            }

        }
    }
}


