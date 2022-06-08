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
    private static Printer print = null;

    public Add(Printer print) {
        this.print = print;
    }

    public static Car addCar() {
        System.out.println("Podaj numer rejestracyjny:");
        String regPlate = keyboard.nextLine();
        regPlate = checkEquals(regPlate);
        System.out.println("Podaj VIN number:");
        String vinNumber = keyboard.nextLine();
        vinNumber = checkEquals(vinNumber);
        LocalDate localDate = addLocalDate();
        System.out.println("Podaj id marki:");
        String idBrand;
        Integer idBrandStringToInt = 0;
        Brand brand;
        Header.displayBrand();
        print.printBrands();
        idBrand = keyboard.nextLine();
        brand = new Brand(idBrandStringToInt = checkVariousEqual(idBrand));
        System.out.println("Podaj id modelu:");
        String idModel;
        Integer idModelStringToInt;
        Model model;
        Header.displayModels();
        print.printModels(new Model(new Brand(idBrandStringToInt)));
        idModel = keyboard.nextLine();
        model = new Model(idModelStringToInt = checkVariousEqual(idModel));
        return new Car(regPlate, vinNumber, localDate, brand, model);
    }

    public static Brand addBrand() {
        System.out.println("Podaj marke:");
        String name = name = keyboard.nextLine();
        return new Brand(name);
    }

    public static Model addModel() {
        String brandId;
        System.out.println("Podaj Id marki:");
        Header.displayBrand();
        print.printBrands();
        brandId = keyboard.nextLine();
        Integer brandIdStringToInt = checkVariousEqual(brandId);
        System.out.println("Podaj nazwe:");
        String name = keyboard.nextLine();
        return new Model(new Brand(brandIdStringToInt), name);
    }

    public static Customer addCustomer() {
        System.out.println("Podaj typ:");
        String type = keyboard.nextLine();
        type = checkEquals(type);
        System.out.println("Podaj nazwe firmy:");
        String companyName = keyboard.nextLine();
        companyName = checkEquals(companyName);
        System.out.println("Podaj tax number:");
        String taxNumber = keyboard.nextLine();
        taxNumber = checkEquals(taxNumber);
        System.out.println("Podaj imie:");
        String firstName = keyboard.nextLine();
        firstName = checkEquals(firstName);
        System.out.println("Podaj nazwisko:");
        String lastName = keyboard.nextLine();
        lastName = checkEquals(lastName);
        System.out.println("Podaj pesel:");
        String pesel = keyboard.nextLine();
        pesel = checkEquals(pesel);
        System.out.println("Podaj numer domu:");
        String houseNumber = keyboard.nextLine();
        houseNumber = checkEquals(houseNumber);
        System.out.println("Podaj numer mieszkania:");
        String flatNumber = keyboard.nextLine();
        flatNumber = checkEquals(flatNumber);
        System.out.println("Podaj nazwe ulicy:");
        String streetName = keyboard.nextLine();
        streetName = checkEquals(streetName);
        System.out.println("Podaj miasto:");
        String city = keyboard.nextLine();
        city = checkEquals(city);
        System.out.println("Podaj kod pocztowy:");
        String postCode = keyboard.nextLine();
        postCode = checkEquals(postCode);
        return new Customer(type, companyName, taxNumber, firstName, lastName, pesel, houseNumber, flatNumber, streetName,
                city, postCode);
    }

    public static Employee addEmployee() {
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

    public static RentInformation addRentInformation() {

        System.out.println("Podaj id samochodu:");
        Header.displayCar();
        print.printCars();
        String carId = keyboard.nextLine();
        Integer carIdStringToInt = checkVariousEqual(carId);
        System.out.println("Podaj date rozpoczecia");
        LocalDateTime rentStart = addDateTime();
        System.out.println("Podaj date zakonczenia:");
        LocalDateTime rentFinish = addDateTime();
        System.out.println("Podaj Id pracownika:");
        Header.displayEmployee();
        print.printEmployee();
        String employeeId = keyboard.nextLine();
        Integer employeeIdStringToInt = checkVariousEqual(employeeId);
        System.out.println("Podaj Id klienta:");
        Header.displayCustomer();
        print.printCustomers();
        String customerId = keyboard.nextLine();
        Integer customerIdStringToInt = checkVariousEqual(customerId);
        System.out.println("Podaj typ:");
        String customerType = keyboard.nextLine();
        customerType = checkEquals(customerType);
        System.out.println("Podaj nazwe firmy:");
        String customerCompanyName = keyboard.nextLine();
        customerCompanyName = checkEquals(customerCompanyName);
        System.out.println("Podaj numer tax:");
        String customerTaxNumber = keyboard.nextLine();
        customerTaxNumber = checkEquals(customerTaxNumber);
        System.out.println("Podaj imie klienta:");
        String customerFirstName = keyboard.nextLine();
        customerFirstName = checkEquals(customerFirstName);
        System.out.println("Podaj nazwisko klienta:");
        String customerLastName = keyboard.nextLine();
        customerLastName = checkEquals(customerLastName);
        System.out.println("Podaj pesel klienta:");
        String customerPesel = keyboard.nextLine();
        customerPesel = checkEquals(customerPesel);
        System.out.println("Podaj numer domu klienta:");
        String customerHouseNumber = keyboard.nextLine();
        customerHouseNumber = checkEquals(customerHouseNumber);
        System.out.println("Podaj numer mieszkania klienta:");
        String customerFlatNumber = keyboard.nextLine();
        customerFlatNumber = checkEquals(customerFlatNumber);
        System.out.println("Podaj nazwe ulicy klienta");
        String customerStreetName = keyboard.nextLine();
        customerStreetName = checkEquals(customerStreetName);
        System.out.println("Podaj miasto klienta:");
        String customerCity = keyboard.nextLine();
        customerCity = checkEquals(customerCity);
        System.out.println("Podja kod pocztowy klienta:");
        String customerPostCode = keyboard.nextLine();
        customerPostCode = checkEquals(customerPostCode);
        System.out.println("Podaj cene netto za dzien:");
        String rentNetPrice = keyboard.nextLine();
        BigDecimal rentNetPriceStringToDecimal = checkVariousEqualDecimal(rentNetPrice);
        System.out.println("Podaj ile procent podatku:");
        String rentPercent = keyboard.nextLine();
        BigDecimal rentPercentStringToDecimal = checkVariousEqualDecimal(rentPercent);
        BigDecimal rentGrossPrice;
        if (rentNetPriceStringToDecimal == null && rentPercentStringToDecimal == null){
            rentGrossPrice = null;
        } else {
            rentGrossPrice = rentNetPriceStringToDecimal.multiply(rentPercentStringToDecimal.add(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(100)));
        }

        return new RentInformation(new Car(carIdStringToInt), rentStart, rentFinish, new Employee(employeeIdStringToInt), new Customer(customerIdStringToInt), customerType, customerCompanyName, customerTaxNumber,
                customerFirstName, customerLastName, customerPesel, customerHouseNumber, customerFlatNumber, customerStreetName,
                customerCity, customerPostCode, rentNetPriceStringToDecimal, rentPercentStringToDecimal, rentGrossPrice);
    }

    public static LocalDateTime addDateTime() {
        System.out.println("Podaj rok:");
        String year = keyboard.nextLine();
        Integer yearStringToInt = checkVariousEqual(year);
        System.out.println("Podaj miesiac:");
        String month = keyboard.nextLine();
        Integer monthStringToInt = checkVariousEqual(month);
        System.out.println("Podaj dzien:");
        String day = keyboard.nextLine();
        Integer dayStringToInt = checkVariousEqual(day);
        System.out.println("Podaj godzine:");
        String houre = keyboard.nextLine();
        Integer hourStringToInt = checkVariousEqual(houre);
        System.out.println("Podaj minuty:");
        String minute = keyboard.nextLine();
        Integer minuteStringToInt = checkVariousEqual(minute);
        LocalDateTime localDateTime;
        if (yearStringToInt == null || monthStringToInt == null || dayStringToInt == null || hourStringToInt == null || minuteStringToInt == null) {
            return null;
        } else {
            return LocalDateTime.of(yearStringToInt, monthStringToInt, dayStringToInt, hourStringToInt, minuteStringToInt);
        }
    }

    public static String checkEquals(String name) {
        if ("".equals(name)) {
            return null;
        }
        return name;
    }

    private static Integer checkVariousEqual(String name) {
        Integer checkVariousEqual;
        if (!"".equals(name)) {
            return checkVariousEqual = Integer.valueOf(name);
        }
        return checkVariousEqual = null;
    }

    private static BigDecimal checkVariousEqualDecimal(String name) {
        BigDecimal checkVariousEqual;
        if (!"".equals(name)) {
            return new BigDecimal(name);
        }
        return checkVariousEqual = null;
    }



    private static LocalDate addLocalDate() {
        System.out.println("Podaj date zakupu:\nRok:");
        String year = keyboard.nextLine();
        Integer yearStringToInt = checkVariousEqual(year);
        System.out.println("Miesiac:");
        String month = keyboard.nextLine();
        Integer monthStringToInt = checkVariousEqual(month);
        System.out.println("Dzien:");
        String day = keyboard.nextLine();
        Integer dayStringToInt = checkVariousEqual(day);
        LocalDate localDate;
        if (yearStringToInt == null || monthStringToInt == null || dayStringToInt == null) {
            return localDate = null;
        }
        return localDate = LocalDate.of(yearStringToInt, monthStringToInt, dayStringToInt);
    }
}
