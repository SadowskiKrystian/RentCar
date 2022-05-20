package com.ksprogramming;

import com.ksprogramming.brand.Brand;
import com.ksprogramming.car.Car;
import com.ksprogramming.customer.Customer;
import com.ksprogramming.employee.Employee;
import com.ksprogramming.model.Model;
import com.ksprogramming.rentinformation.RentInformation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Add {
    private static Scanner keyboard = new Scanner(System.in);
    private static Print print = null;

    public Add(Print print) {
        this.print = print;
    }

    public static Car addCar(Boolean fullInformation) {
        keyboard.nextLine();
        System.out.println("Podaj numer rejestracyjny:");
        String regPlate = keyboard.nextLine();
        System.out.println("Podaj VIN number:");
        String vinNumber = keyboard.nextLine();
        System.out.println("Podaj date zakupu:\nRok:");
        int year = keyboard.nextInt();
        System.out.println("Miesiac:");
        int month = keyboard.nextInt();
        System.out.println("Dzien:");
        int day = keyboard.nextInt();
        System.out.println("Podaj id marki:");
        int idBrand;
        if (fullInformation == true) {
            Header.displayBrand();
            print.printBrand();
            idBrand = keyboard.nextInt();
        } else {
            idBrand = keyboard.nextInt();
        }
        System.out.println("Podaj id modelu:");
        int idModel;
        if (fullInformation == true) {
            Header.displayModels();
            print.printModels(new Model(idBrand));
            idModel = keyboard.nextInt();
        } else {
            idModel = keyboard.nextInt();
        }
        return new Car(regPlate, vinNumber, LocalDate.of(year, month, day), new Brand(idBrand), new Model(idModel));
    }

    public static Brand addBrand() {
        keyboard.nextLine();
        System.out.println("Podaj marke:");
        String name = name = keyboard.nextLine();
        return new Brand(name);
    }

    public static Model addModel(Boolean fullInformation) {
        keyboard.nextLine();
        Integer brandId;
        System.out.println("Podaj Id marki:");
        if (fullInformation == true) {
            Header.displayBrand();
            print.printBrand();
            brandId = keyboard.nextInt();
        } else {
            brandId = keyboard.nextInt();
        }
        keyboard.nextLine();
        System.out.println("Podaj nazwe:");
        String name = keyboard.nextLine();
        return new Model(new Brand(brandId), name);
    }

    public static Customer addCustomer() {
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

    public static Employee addEmployee() {
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
        System.out.println("Podaj kod pocztowy:");
        String postCode = keyboard.nextLine();
        return new Employee(firstName, lastName, pesel, houseNumber, flatNumber, streetName, city, postCode);
    }

    public static RentInformation addRentInformation(Boolean fullInformation) {
        keyboard.nextLine();
        Integer carId;
        System.out.println("Podaj id samochodu:");
        if (fullInformation == true) {
            Header.displayCar();
            print.printCar();
            carId = keyboard.nextInt();
        } else {
            carId = keyboard.nextInt();
        }
        System.out.println("Podaj date rozpoczecia");
        LocalDateTime rentStart = addDateTime();
        System.out.println("Podaj date zakonczenia:");
        LocalDateTime rentFinish = addDateTime();
        Integer employeeId;
        System.out.println("Podaj Id pracownika:");
        if (fullInformation == true) {
            Header.displayEmployee();
            print.printEmployee();
            employeeId = keyboard.nextInt();
        } else {
            employeeId = keyboard.nextInt();
        }
        Integer customerId;
        System.out.println("Podaj Id klienta:");
        if (fullInformation == true) {
            Header.displayCustomer();
            print.printCustomer();
            customerId = keyboard.nextInt();
        } else {
            customerId = keyboard.nextInt();
        }
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

        return new RentInformation(new Car(carId), rentStart, rentFinish, new Employee(employeeId), new Customer(customerId), customerType, customerCompanyName, customerTaxNumber,
                customerFirstName, customerLastName, customerPesel, customerHouseNumber, customerFlatNumber, customerStreetName,
                customerCity, customerPostCode, rentNetPrice, rentPercent, rentGrossPrice);
    }

    public static LocalDateTime addDateTime() {
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
}
