package com.ksprogramming;

import com.ksprogramming.brand.Brand;
import com.ksprogramming.brand.BrandService;
import com.ksprogramming.car.Car;
import com.ksprogramming.car.CarService;
import com.ksprogramming.customer.Customer;
import com.ksprogramming.customer.CustomerService;
import com.ksprogramming.employee.Employee;
import com.ksprogramming.employee.EmployeeService;
import com.ksprogramming.model.Model;
import com.ksprogramming.model.ModelService;
import com.ksprogramming.rentinformation.RentInformation;
import com.ksprogramming.rentinformation.RentInformationService;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.zip.DataFormatException;

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

        String url = "jdbc:mysql://localhost:3306/RentCar";
        String user = "root";
        String password = "Krystian87.pl";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
            CustomerService customerService = new CustomerService(connection);
            EmployeeService employeeService = new EmployeeService(connection);
            BrandService brandService = new BrandService(connection);
            ModelService modelService = new ModelService(connection);
            CarService carService = new CarService(connection);
            RentInformationService rentInformationService = new RentInformationService(connection);

//            rentInformationService.create(new RentInformation(1, LocalDateTime.of( 2020,11,12,12,20), LocalDateTime.of(2020,11,15,12,20),
//                    1, 1, "P", null, null, "Adam", "Kulinski", "690713",
//                    "11", null, "Chestnut grow",
//                    "Aughnacloy", "BT696AD", BigDecimal.valueOf(40), BigDecimal.valueOf(23), BigDecimal.valueOf(49.2)));
            //System.out.println(rentInformationService.getId(1));
            rentInformationService.find(new RentInformation(null, null , null, null,
                    null, null, null, null, "Adam",
                    null, null, null, null, null,
                    null, null, null, null, null)).stream().forEach(System.out::println);
            // carService.create(new Car("VHZ2243", "XDFA00ggrrgf0", LocalDate.of(2020, 06, 11), 1, 1));
            // LocalDateTime time = LocalDateTime.now();
            //String europeanDatePattern = "yyyy/MM/dd";
            //DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
            //System.out.println(europeanDateFormatter.format(time));

            //modelService.create(new Model(1, "Q7"));
            //System.out.println(modelService.getId(1));
            //modelService.find(new Model(1, null)).stream().forEach(System.out::println);

            //brandService.create(new Brand("Audi"));
            //System.out.println(brandService.getId(1));
            //brandService.find(new Brand(null)).stream().forEach(System.out::println);

            //employeeService.create(new Employee("Krystian", "Sadowski", "870411", "39", null, "Coronation Park", "Aughnacloy","Bt696aw"));
           //employeeService.update(1, new Employee("Krystian", "Sadowski", "870430", "39", "1", "Coronation Park", "Aughnacloy","Bt696aw"));
            //employeeService.find(new Employee("Krystian", null, null, null, null, null, "Aughnacloy","Bt696aw")).stream().forEach(System.out::println);
            //System.out.println(customerService.get(2));

            //customerService.create(new Customer("P", null, null, "Alan", "Sadowski",
            //      "170406", "1", null, "Zmarlego Putina", "Aughnacloy", "BT696AW"));
            //customerService.update(3,new Customer("P", null, null, "Krystian", "Sadowski",
            //      "870411", "39", null, "Coronation Park", "Aughnacloy", "BT696AW"));
            //customerService.remove(3);
            //System.out.println(customerService.get(1));
            //customerService.find();
//            customerService.find(new Customer(null,null,null,"Adam",null,
//                    null,null,null,null,null, null)).stream()
//                    .forEach(System.out::println);
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


