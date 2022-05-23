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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {
    private static boolean exitApplication = true;
    private static Scanner keyboard = new Scanner(System.in);
    private static CustomerService customerService = null;
    private static EmployeeService employeeService = null;
    private static BrandService brandService = null;
    private static ModelService modelService = null;
    private static CarService carService = null;
    private static RentInformationService rentInformationService = null;

    public Menu(CustomerService customerService, EmployeeService employeeService,
                BrandService brandService, ModelService modelService, CarService carService, RentInformationService rentInformationService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.carService = carService;
        this.rentInformationService = rentInformationService;
    }

    private static void displayCar(Car car) {
        System.out.printf("%-5s", car.getId());
        System.out.printf("%-15s", car.getRegistrationPlate());
        System.out.printf("%-15s", car.getVinNumber());
        System.out.printf("%-15s", car.getPurchaseDate());
        System.out.printf("%-15s", car.getBrand().getName());
        System.out.printf("%-15s", car.getBrand().getName());
        System.out.println("");
    }

    public void showChoosenMenu() {
        while (exitApplication) {
            showMenu();
            menu(chooseMenu());
        }
    }

    private static void showMenu() {
        System.out.println("Witamy w aplikacji do wynajmowania samochodow");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Wybierz z menu co chcesz zrobić:");
        System.out.println("1 - Dodaj samochód\n" +
                "2 - Znajdź samochód po danych\n" +
                "3 - Znajdz samochód po Id\n" +
                "4 - Zaktualizuj samochód\n" +
                "5 - Usun samochód\n" +
                "6 - Pokaż wszystkie samochody\n" +
                "------------------------\n" +
                "7 - Dodaj markę\n" +
                "8 - Znajdź markę po danych\n" +
                "9 - Znajdz markę po Id\n" +
                "10 - Zaktualizuj markę\n" +
                "11 - Usun markę\n" +
                "12 - Pokaż wszystkie marki\n" +
                "------------------------\n" +
                "13 - Dodaj model\n" +
                "14 - Znajdź model po danych\n" +
                "15 - Znajdz model po Id\n" +
                "16 - Zaktualizuj model\n" +
                "17 - Usun model\n" +
                "18 - Pokaż wszystkie modele\n" +
                "------------------------\n" +
                "19 - Dodaj pracownika\n" +
                "20 - Znajdź pracownika po danych\n" +
                "21 - Znajdz pracownika po Id\n" +
                "22 - Zaktualizuj pracownika\n" +
                "23 - Usun pracownika\n" +
                "24 - Pokaż wszystkich pracowników\n" +
                "------------------------\n" +
                "25 - Dodaj klienta\n" +
                "26 - Znajdź klienta po danych\n" +
                "27 - Znajdz klienta po Id\n" +
                "28 - Zaktualizuj klienta\n" +
                "29 - Usun klienta\n" +
                "30 - Pokaż wszystkich klientów\n" +
                "------------------------\n" +
                "31 - Dodaj informacje o wypożyczeniu\n" +
                "32 - Znajdź informacje o wypożyczeniu po danych\n" +
                "33 - Znajdz informacje o wypożyczeniu po Id\n" +
                "34 - Zaktualizuj informacje o wypożyczeniu\n" +
                "35 - Usun informacje o wypożyczeniu\n" +
                "36 - Pokaż wszystkie wypożyczenia\n" +
                "------------------------\n" +
                "36 - Zamknij aplikacje");
    }

    private static void menu(MenuItem chooseMenu) {
        switch (chooseMenu) {
            case ADD_CAR:
                carService.create(car(true));
                break;
            case FIND_CAR:
                carService.find(car(false));
                break;
            case FIND_BY_ID_CAR:
                carService.getId(id());
                break;
            case UPDATE_CAR:
                printCar();
                carService.update(id(), car(true));
                break;
            case DELETE_CAR:
                printCar();
                carService.remove(id());
                break;
            case SHOW_CAR:
                printCar();
                stopLoop();
                break;
            case ADD_BRAND:
                brandService.create(brand());
                break;
            case FIND_BRAND:
                brandService.find(brand());
                break;
            case FIND_BY_ID_BRAND:
                brandService.getId(id());
                break;
            case UPDATE_BRAND:
                printBrand();
                brandService.update(id(), brand());
                break;
            case DELETE_BRAND:
                printBrand();
                brandService.remove(id());
                break;
            case SHOW_BRAND:
                printBrand();
                stopLoop();
                break;
            case ADD_MODEL:
                modelService.create(model(true));
                break;
            case FIND_MODEL:
                modelService.find(model(false));
                break;
            case FIND_BY_ID_MODEL:
                modelService.getId(id());
                break;
            case UPDATE_MODEL:
                printModel();
                modelService.update(id(), model(true));
                break;
            case DELETE_MODEL:
                printModel();
                modelService.remove(id());
                break;
            case SHOW_MODEL:
                printModel();
                stopLoop();
                break;
            case ADD_EMPLOYEE:
                employeeService.create(employee());
                break;
            case FIND_EMPLOYEE:
                employeeService.find(employee());
                break;
            case FIND_BY_ID_EMPLOYEE:
                employeeService.getId(id());
                break;
            case UPDATE_EMPLOYEE:
                printEmployee();
                employeeService.update(id(), employee());
                break;
            case DELETE_EMPLOYEE:
                printEmployee();
                employeeService.remove(id());
                break;
            case SHOW_EMPLOYEE:
                printEmployee();
                stopLoop();
                break;
            case ADD_CUSTOMER:
                customerService.create(customer());
                break;
            case FIND_CUSTOMER:
                customerService.find(customer());
                break;
            case FIND_BY_ID_CUSTOMER:
                customerService.getId(id());
                break;
            case UPDATE_CUSTOMER:
                printCustomer();
                customerService.update(id(), customer());
                break;
            case DELETE_CUSTOMER:
                printCustomer();
                customerService.remove(id());
                break;
            case SHOW_CUSTOMER:
                printCustomer();
                stopLoop();
                break;
            case ADD_RENT:
                rentInformationService.create(rentInformation(false));
                break;
            case FIND_RENT:
                rentInformationService.find(rentInformation(false));
                break;
            case FIND_BY_ID_RENT:
                rentInformationService.getId(id());
                break;
            case UPDATE_RENT:
                printRentInformation();
                rentInformationService.update(id(), rentInformation(true));
                break;
            case DELETE_RENT:
                printRentInformation();
                rentInformationService.remove(id());
                break;
            case SHOW_RENT:
                printRentInformation();
                stopLoop();
                break;
            case EXIT:
                exitApplication = false;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static void printRentInformation() {
        System.out.printf("%-15s", "Id:");
        System.out.printf("%-15s", "Id Auta:");
        System.out.printf("%-30s", "Start wynaj:");
        System.out.printf("%-30s", "Koniec wynaj:");
        System.out.printf("%-15s", "Id prac.:");
        System.out.printf("%-15s", "Id klienta:");
        System.out.printf("%-15s", "Typ:");
        System.out.printf("%-30s", "Nazwa firmy");
        System.out.printf("%-15s", "Numer tax");
        System.out.printf("%-15s", "Imię:");
        System.out.printf("%-15s", "Nazwisko:");
        System.out.printf("%-15s", "Pesel:");
        System.out.printf("%-15s", "Nr domu:");
        System.out.printf("%-15s", "Nr miesz.:");
        System.out.printf("%-25s", "Ulica:");
        System.out.printf("%-15s", "Miasto:");
        System.out.printf("%-15s", "Kod pocztowy:");
        System.out.println("");
        rentInformationService.find(new RentInformation(null, null, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null))
                .stream().forEach(text -> {
                    System.out.printf("%-15s", text.getId());
                    System.out.printf("%-15s", text.getCarId());
                    System.out.printf("%-30s", text.getRentStart());
                    System.out.printf("%-30s", text.getRentFinish());
                    System.out.printf("%-15s", text.getEmployeeId());
                    System.out.printf("%-15s", text.getCustomerId());
                    System.out.printf("%-15s", text.getCustomerType());
                    System.out.printf("%-30s", text.getCustomerCompanyName());
                    System.out.printf("%-15s", text.getCustomerTaxNumber());
                    System.out.printf("%-15s", text.getCustomerFirstName());
                    System.out.printf("%-15s", text.getCustomerLastName());
                    System.out.printf("%-15s", text.getCustomerPesel());
                    System.out.printf("%-15s", text.getCustomerHouseNumber());
                    System.out.printf("%-15s", text.getCustomerFlatNumber());
                    System.out.printf("%-25s", text.getCustomerStreetName());
                    System.out.printf("%-15s", text.getCustomerCity());
                    System.out.printf("%-15s", text.getCustomerPostCode());
                    System.out.println("");
                });
    }

    private static void printCustomer() {
        System.out.printf("%-15s", "Id:");
        System.out.printf("%-15s", "Typ:");
        System.out.printf("%-30s", "Nazwa firmy");
        System.out.printf("%-15s", "Numer tax");
        System.out.printf("%-15s", "Imię:");
        System.out.printf("%-15s", "Nazwisko:");
        System.out.printf("%-15s", "Pesel:");
        System.out.printf("%-15s", "Nr domu:");
        System.out.printf("%-15s", "Nr miesz.:");
        System.out.printf("%-25s", "Ulica:");
        System.out.printf("%-15s", "Miasto:");
        System.out.printf("%-15s", "Kod pocztowy:");
        System.out.println("");
        customerService.find(new Customer(null, null, null, null, null, null, null, null, null, null, null))
                .stream().forEach(text -> {
                    System.out.printf("%-15s", text.getId());
                    System.out.printf("%-15s", text.getType());
                    System.out.printf("%-30s", text.getCompanyName());
                    System.out.printf("%-15s", text.getTaxNumber());
                    System.out.printf("%-15s", text.getFirstName());
                    System.out.printf("%-15s", text.getLastName());
                    System.out.printf("%-15s", text.getPesel());
                    System.out.printf("%-15s", text.getHouseNumber());
                    System.out.printf("%-15s", text.getFlatNumber());
                    System.out.printf("%-25s", text.getStreetName());
                    System.out.printf("%-15s", text.getCity());
                    System.out.printf("%-15s", text.getPostCode());
                    System.out.println("");
                });
    }

    private static void printEmployee() {
        System.out.printf("%-15s", "Id:");
        System.out.printf("%-15s", "Imię:");
        System.out.printf("%-15s", "Nazwisko:");
        System.out.printf("%-15s", "Pesel:");
        System.out.printf("%-15s", "Nr domu:");
        System.out.printf("%-15s", "Nr miesz.:");
        System.out.printf("%-25s", "Ulica:");
        System.out.printf("%-15s", "Miasto:");
        System.out.printf("%-15s", "Kod pocztowy:");
        System.out.println("");
        employeeService.find(new Employee(null, null, null, null, null, null, null, null)).stream()
                .forEach(text -> {
                    System.out.printf("%-15s", text.getId());
                    System.out.printf("%-15s", text.getFirstName());
                    System.out.printf("%-15s", text.getLastName());
                    System.out.printf("%-15s", text.getPesel());
                    System.out.printf("%-15s", text.getHouseNumber());
                    System.out.printf("%-15s", text.getFlatNumber());
                    System.out.printf("%-25s", text.getStreetName());
                    System.out.printf("%-15s", text.getCity());
                    System.out.printf("%-15s", text.getPostCode());
                    System.out.println("");
                });
    }

    private static void printCar() {
        printCarsHeader("%-5s", "Id:", "Reg nr:", "Numer Vin:", "%-15s", "Data zakupu:", "Marka:", "Model:");
        printCars();
    }

    private static void printCars() {
        carService.find(new Car())
                .stream().forEach(Menu::displayCar);
    }

    private static void printCarsHeader(String s, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        System.out.printf(s, s2);
        System.out.printf("%-15s", s3);
        System.out.printf("%-15s", s4);
        System.out.printf(s5, s6);
        System.out.printf("%-15s", s7);
        System.out.printf("%-15s", s8);
        System.out.println("");
    }

    private static void printBrand() {
        System.out.printf("%-15s", "Id:");
        System.out.printf("%-15s", "Marka:");
        System.out.println("");
        brandService.find(new Brand()).stream()
                .forEach(text -> {
                    System.out.printf("%-15s", text.getId());
                    System.out.printf("%-15s", text.getName());
                    System.out.println("");
                });
    }

    private static void printModel() {
        System.out.printf("%-15s", "Id:");
        System.out.printf("%-15s", "Marka id:");
        System.out.printf("%-15s", "Model:");
        System.out.println("");
        modelService.find(new Model(null, null)).stream()
                .forEach(text -> {
                    System.out.printf("%-15s", text.getId());
                    System.out.printf("%-15s", text.getBrandId());
                    System.out.printf("%-15s", text.getName());
                    System.out.println("");
                });
    }

    private static Car car(Boolean fullInformation) {
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
        int brandId;
        if (fullInformation == true) {
            printBrand();
            brandId = keyboard.nextInt();
        } else {
            brandId = keyboard.nextInt();
        }
        System.out.println("Podaj model");
        int modelId;
        if (fullInformation == true) {
            printModel();
            modelId = keyboard.nextInt();
        } else {
            modelId = keyboard.nextInt();
        }
        return new Car(regPlate, vinNumber, LocalDate.of(year, month, day), new Brand(brandId), new Model(modelId));
    }

    private static Brand brand() {
        keyboard.nextLine();
        System.out.println("Podaj marke:");
        String name = name = keyboard.nextLine();
        return new Brand(name);
    }

    private static Model model(Boolean fullInformation) {
        keyboard.nextLine();
        Integer brandId;
        System.out.println("Podaj Id marki:");
        if (fullInformation == true) {
            printBrand();
            brandId = keyboard.nextInt();
        } else {
            brandId = keyboard.nextInt();
        }
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
        System.out.println("Podaj kod pocztowy:");
        String postCode = keyboard.nextLine();
        return new Employee(firstName, lastName, pesel, houseNumber, flatNumber, streetName, city, postCode);
    }

    private static RentInformation rentInformation(Boolean fullInformation) {
        keyboard.nextLine();
        Integer carId;
        System.out.println("Podaj id samochodu:");
        if (fullInformation == true) {
            printCar();
            carId = keyboard.nextInt();
        } else {
            carId = keyboard.nextInt();
        }
        System.out.println("Podaj date rozpoczecia");
        LocalDateTime rentStart = dateTime();
        System.out.println("Podaj date zakonczenia:");
        LocalDateTime rentFinish = dateTime();
        Integer employeeId;
        System.out.println("Podaj Id pracownika:");
        if (fullInformation == true) {
            printRentInformation();
            employeeId = keyboard.nextInt();
        } else {
            employeeId = keyboard.nextInt();
        }
        Integer customerId;
        System.out.println("Podaj Id klienta:");
        if (fullInformation == true) {
            printRentInformation();
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
        System.out.println("Podaj numer z menu:");
        Integer chooseMenu = keyboard.nextInt();
        return prepareMenuItem(chooseMenu);
    }

    private static MenuItem prepareMenuItem(Integer chosenMenu) {
        switch (chosenMenu) {
            case 1:
                return MenuItem.ADD_CAR;
            case 2:
                return MenuItem.FIND_CAR;
            case 3:
                return MenuItem.FIND_BY_ID_CAR;
            case 4:
                return MenuItem.UPDATE_CAR;
            case 5:
                return MenuItem.DELETE_CAR;
            case 6:
                return MenuItem.SHOW_CAR;
            case 7:
                return MenuItem.ADD_BRAND;
            case 8:
                return MenuItem.FIND_BRAND;
            case 9:
                return MenuItem.FIND_BY_ID_BRAND;
            case 10:
                return MenuItem.UPDATE_BRAND;
            case 11:
                return MenuItem.DELETE_BRAND;
            case 12:
                return MenuItem.SHOW_BRAND;
            case 13:
                return MenuItem.ADD_MODEL;
            case 14:
                return MenuItem.FIND_MODEL;
            case 15:
                return MenuItem.FIND_BY_ID_MODEL;
            case 16:
                return MenuItem.UPDATE_MODEL;
            case 17:
                return MenuItem.DELETE_MODEL;
            case 18:
                return MenuItem.SHOW_MODEL;
            case 19:
                return MenuItem.ADD_EMPLOYEE;
            case 20:
                return MenuItem.FIND_EMPLOYEE;
            case 21:
                return MenuItem.FIND_BY_ID_EMPLOYEE;
            case 22:
                return MenuItem.UPDATE_EMPLOYEE;
            case 23:
                return MenuItem.DELETE_EMPLOYEE;
            case 24:
                return MenuItem.SHOW_EMPLOYEE;
            case 25:
                return MenuItem.ADD_CUSTOMER;
            case 26:
                return MenuItem.FIND_CUSTOMER;
            case 27:
                return MenuItem.FIND_BY_ID_CUSTOMER;
            case 28:
                return MenuItem.UPDATE_CUSTOMER;
            case 29:
                return MenuItem.DELETE_CUSTOMER;
            case 30:
                return MenuItem.SHOW_CUSTOMER;
            case 31:
                return MenuItem.ADD_RENT;
            case 32:
                return MenuItem.FIND_RENT;
            case 33:
                return MenuItem.FIND_BY_ID_RENT;
            case 34:
                return MenuItem.UPDATE_RENT;
            case 35:
                return MenuItem.DELETE_RENT;
            case 36:
                return MenuItem.SHOW_RENT;
            case 37:
                return MenuItem.EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static void stopLoop() {
        System.out.println("Przycisnij Enter aby wrócić do aplikacji:");
        keyboard.nextLine();
        String continued = keyboard.nextLine();
    }
}
