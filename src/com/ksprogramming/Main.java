package com.ksprogramming;

import com.ksprogramming.brand.BrandService;
import com.ksprogramming.car.CarService;
import com.ksprogramming.customer.CustomerService;
import com.ksprogramming.employee.EmployeeService;
import com.ksprogramming.model.ModelService;
import com.ksprogramming.rentinformation.RentInformationService;

import java.sql.*;
import java.util.InputMismatchException;

public class Main {
    private static boolean exitApplication = true;

    private static Connection connection = null;
    private static CustomerService customerService = null;
    private static EmployeeService employeeService = null;
    private static BrandService brandService = null;
    private static ModelService modelService = null;
    private static CarService carService = null;
    private static RentInformationService rentInformationService = null;
    private static Menu menu = null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver loaded");
        } catch (Exception ex) {
            System.out.println("Problem with driver");
            ex.printStackTrace();
        }


        String url = "jdbc:mysql://localhost:3306/RentCar";
        String user = "root";
        String password = "Krystianjava87pl";

        try {
            connection = DriverManager.getConnection(url, user, password);
            customerService = new CustomerService(connection);
            employeeService = new EmployeeService(connection);
            brandService = new BrandService(connection);
            modelService = new ModelService(connection);
            carService = new CarService(connection);
            rentInformationService = new RentInformationService(connection);
            menu = new Menu(customerService, employeeService, brandService, modelService, carService, rentInformationService);
            System.out.println("Connected");
            menu.showChoosenMenu();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Podales nie poprawna wartosc");
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


