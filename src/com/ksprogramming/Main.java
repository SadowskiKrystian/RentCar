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
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static boolean exitApplication = true;
    private static Scanner keyboard = new Scanner(System.in);
    private static Connection connection = null;
    private static CustomerService customerService = null;
    private static EmployeeService employeeService = null;
    private static BrandService brandService = null;
    private static ModelService modelService = null;
    private static CarService carService = null;
    private static RentInformationService rentInformationService = null;

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
            System.out.println("Connected");
            while (exitApplication){
                showMenu();
                chooseNumberMenu();
            }
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


    private static void showMenu() {
        System.out.println("Witamy w aplikacji do wynajmowania samochodow");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Wybierz z menu co chcesz zrobić:");
        System.out.println("1 - Dodaj do bazy danych\n2 - Zmien dane w bazie danych\n3 - Znajdz po Id\n4 - Znajdz po danych\n5 - "
                + "Usun z bazy danych\n6 - Zamknij aplikacje");
    }

    private static void showSubMenu() {
        System.out.println("Wybierz w ktorej bazie chcesz dodac dane:\n1 - Samochod\n2 - Marka\n3 - Model\n4 - Pracownicy" +
                "\n5 - Klienci\n6 - Wynajem auta");
    }

    private static void chooseNumberMenu() {

        switch (chooseMenu()) {
            case ADD:
                showSubMenu();
                chooseCreateSubMenuNumber(chooseMenu());
                break;
            case CHANGE:
                showSubMenu();
                chooseUpdateSubMenuNumber(chooseMenu());
                break;
            case FIND_BY_ID:
                showSubMenu();
                chooseGetIdSubMenuNumber(chooseMenu());
                break;
            case FIND:
                showSubMenu();
                printResults(chooseMenu());
                break;
            case DELETE:
                showSubMenu();
                chooseDeleteSubMenuNumber(chooseMenu());
                break;
            case EXIT:
                exitApplication = false;
                break;
        }
    }

    private static void chooseCreateSubMenuNumber(MenuItem chosenMenu) {
        switch (chosenMenu) {
            case 1:
                carService.create(car());
                break;
            case 2:
                brandService.create(brand());
                break;
            case 3:
                modelService.create(model());
                break;
            case 4:
                employeeService.create(employee());
                break;
            case 5:
                customerService.create(customer());
                break;
            case 6:
                rentInformationService.create(rentInformation());
                break;
        }
    }

    private static void chooseGetIdSubMenuNumber(MenuItem chosenMenu) {
        switch (chosenMenu) {
            case 1:
                System.out.println(carService.getId(id()));
                break;
            case 2:
                System.out.println(brandService.getId(id()));
                break;
            case 3:
                System.out.println(modelService.getId(id()));
                break;
            case 4:
                System.out.println(employeeService.getId(id()));
                break;
            case 5:
                System.out.println(customerService.getId(id()));
                break;
            case 6:
                System.out.println(rentInformationService.getId(id()));
                break;
        }
    }

    private static void printResults(MenuItem chosenMenu) {
        switch (chosenMenu) {
            case 1:
                carService.find(car()).stream().forEach(System.out::println);
                break;
            case 2:
                brandService.find(brand()).stream().forEach(System.out::println);
                break;
            case 3:
                modelService.find(model()).stream().forEach(System.out::println);
                break;
            case 4:
                employeeService.find(employee()).stream().forEach(System.out::println);
                break;
            case 5:
                customerService.find(customer()).stream().forEach(System.out::println);
                break;
            case 6:
                rentInformationService.find(rentInformation()).stream().forEach(System.out::println);
                break;
        }
    }

    private static void chooseUpdateSubMenuNumber(MenuItem chosenMenu) {
        switch (chosenMenu) {
            case 1:
                carService.update(id(), car());
                break;
            case 2:
                brandService.update(id(), brand());
                break;
            case 3:
                modelService.update(id(), model());
                break;
            case 4:
                employeeService.update(id(), employee());
                break;
            case 5:
                customerService.update(id(), customer());
                break;
            case 6:
                rentInformationService.update(id(), rentInformation());
                break;
        }
    }

    private static void chooseDeleteSubMenuNumber(MenuItem chosenMenu) {
        switch (chosenMenu) {
            case 1:
                carService.remove(id());
                break;
            case 2:
                brandService.remove(id());
                break;
            case 3:
                modelService.remove(id());
                break;
            case 4:
                employeeService.remove(id());
                break;
            case 5:
                customerService.remove(id());
                break;
            case 6:
                rentInformationService.remove(id());
                break;
        }
    }

    private static Car car() {
        keyboard.nextLine();
        System.out.println("Podaj numer rejestracyjny");
        String regPlate = keyboard.nextLine();
        System.out.println("Podaj VIN number");
        String vinNumber = keyboard.nextLine();
        System.out.println("Podaj date zakupu\n rok:");
        int year = keyboard.nextInt();
        System.out.println("miesiac:");
        int month = keyboard.nextInt();
        System.out.println("dzien:");
        int day = keyboard.nextInt();
        System.out.println("Podaj marke:");
        int brand = keyboard.nextInt();
        System.out.println("Podaj model");
        int model = keyboard.nextInt();
        return new Car(regPlate, vinNumber, LocalDate.of(year, month, day), brand, model);
    }

    private static Brand brand() {
        keyboard.nextLine();
        System.out.println("Podaj marke:");
        String name = keyboard.nextLine();
        return new Brand(name);
    }

    private static Model model() {
        keyboard.nextLine();
        System.out.println("Podaj Id marki:");
        Integer brandId = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Podaj nazwe:");
        String name = keyboard.nextLine();
        return new Model(brandId, name);
    }

    private static Customer customer() {
        keyboard.nextLine();
        System.out.println("Podaj typ:");
        String type = keyboard.nextLine();
        System.out.println("Podaj nazwe firmy:");
        String companyName = keyboard.nextLine();
        System.out.println("Podaj tax number:");
        String taxNumber = keyboard.nextLine();
        System.out.println("Podaj imie:");
        String firstName = keyboard.nextLine();
        System.out.println("Podaj nazwisko:");
        String lastName = keyboard.nextLine();
        System.out.println("Podaj pesel:");
        String pesel = keyboard.nextLine();
        System.out.println("Podaj numer domu:");
        String houseNumber = keyboard.nextLine();
        System.out.println("Podaj numer mieszkania:");
        String flatNumber = keyboard.nextLine();
        System.out.println("Podaj nazwe ulicy:");
        String streetName = keyboard.nextLine();
        System.out.println("Podaj miasto:");
        String city = keyboard.nextLine();
        System.out.println("Podaj kod pocztowy:");
        String postCode = keyboard.nextLine();
        return new Customer(type, companyName, taxNumber, firstName, lastName, pesel, houseNumber, flatNumber, streetName,
                city, postCode);
    }

    private static Employee employee() {
        keyboard.nextLine();
        System.out.println("Podaj imie:");
        String firstName = keyboard.nextLine();
        System.out.println("Podaj nazwisko:");
        String lastName = keyboard.nextLine();
        System.out.println("Podaj pesel:");
        String pesel = keyboard.nextLine();
        System.out.println("Podaj numer domu:");
        String houseNumber = keyboard.nextLine();
        System.out.println("Podaj numer mieszkania:");
        String flatNumber = keyboard.nextLine();
        System.out.println("Podaj nazwe ulicy:");
        String streetName = keyboard.nextLine();
        System.out.println("Podaj miasto:");
        String city = keyboard.nextLine();
        System.out.println("podaj kod pocztowy:");
        String postCode = keyboard.nextLine();
        return new Employee(firstName, lastName, pesel, houseNumber, flatNumber, streetName, city, postCode);
    }

    private static RentInformation rentInformation() {
        keyboard.nextLine();
        System.out.println("Podaj id samochodu:");
        Integer carId = keyboard.nextInt();
        System.out.println("Podaj date rozpoczecia");
        LocalDateTime rentStart = dateTime();
        System.out.println("Podaj date zakonczenia:");
        LocalDateTime rentFinish = dateTime();
        System.out.println("Podaj Id pracownika:");
        Integer employeeId = keyboard.nextInt();
        System.out.println("Podaj Id klienta:");
        Integer customerId = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Podaj typ:");
        String customerType = keyboard.nextLine();
        System.out.println("Podaj nazwe firmy:");
        String customerCompanyName = keyboard.nextLine();
        System.out.println("Podaj numer tax:");
        String customerTaxNumber = keyboard.nextLine();
        System.out.println("Podaj imie klienta:");
        String customerFirstName = keyboard.nextLine();
        System.out.println("Podaj nazwisko klienta:");
        String customerLastName = keyboard.nextLine();
        System.out.println("Podaj pesel klienta:");
        String customerPesel = keyboard.nextLine();
        System.out.println("Podaj numer domu klienta:");
        String customerHouseNumber = keyboard.nextLine();
        System.out.println("Podaj numer mieszkania klienta:");
        String customerFlatNumber = keyboard.nextLine();
        System.out.println("Podaj nazwe ulicy klienta");
        String customerStreetName = keyboard.nextLine();
        System.out.println("Podaj miasto klienta:");
        String customerCity = keyboard.nextLine();
        System.out.println("Podja kod pocztowy klienta:");
        String customerPostCode = keyboard.nextLine();
        System.out.println("Podaj cene netto za dzien:");
        BigDecimal rentNetPrice = keyboard.nextBigDecimal();
        System.out.println("Podaj ile procent podatku:");
        BigDecimal rentPercent = keyboard.nextBigDecimal();
        BigDecimal rentGrossPrice = rentNetPrice.multiply(rentPercent.add(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(100)));

        return new RentInformation(carId, rentStart, rentFinish, employeeId, customerId, customerType, customerCompanyName, customerTaxNumber,
                customerFirstName, customerLastName, customerPesel, customerHouseNumber, customerFlatNumber, customerStreetName,
                customerCity, customerPostCode, rentNetPrice, rentPercent, rentGrossPrice);
    }

    private static LocalDateTime dateTime() {
        keyboard.nextLine();
        System.out.println("Podaj rok:");
        Integer year = keyboard.nextInt();
        System.out.println("Podaj miesiac:");
        Integer month = keyboard.nextInt();
        System.out.println("Podaj dzien:");
        Integer day = keyboard.nextInt();
        System.out.println("Podaj godzine:");
        Integer hour = keyboard.nextInt();
        System.out.println("Podaj minuty:");
        Integer minute = keyboard.nextInt();
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    private static Integer id() {
        keyboard.nextLine();
        System.out.println("Podaj numer Id:");
        Integer id = keyboard.nextInt();
        return id;
    }

    private static MenuItem chooseMenu() {
        Integer chooseMenu = keyboard.nextInt();
        return prepareMenuItem(chooseMenu);
    }

    private static MenuItem prepareMenuItem(Integer chosenMenu){
        switch (chosenMenu){
            case 1:
                return MenuItem.ADD;
            case 2:
                return MenuItem.CHANGE;
            case 3:
                return MenuItem.FIND_BY_ID;
            case 4:
                return MenuItem.FIND;
            case 5:
                return MenuItem.DELETE;
            case 6:
                return MenuItem.EXIT;
            default:
                throw new IllegalArgumentException();
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


