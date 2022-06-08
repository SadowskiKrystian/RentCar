package com.ksprogramming;

import com.ksprogramming.brand.Brand;
import com.ksprogramming.brand.BrandService;
import com.ksprogramming.car.Car;
import com.ksprogramming.car.CarService;
import com.ksprogramming.customer.Customer;
import com.ksprogramming.customer.CustomerService;
import com.ksprogramming.employee.EmployeeService;
import com.ksprogramming.model.Model;
import com.ksprogramming.model.ModelService;
import com.ksprogramming.rentinformation.RentInformationService;

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
    private static Printer print = null;
    private static Add add = null;

    public Menu(CustomerService customerService, EmployeeService employeeService,
                BrandService brandService, ModelService modelService, CarService carService, RentInformationService rentInformationService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.carService = carService;
        this.rentInformationService = rentInformationService;
        print = new Printer(customerService, employeeService, brandService, modelService, carService, rentInformationService);
        add = new Add(print);
    }

    public void showChoosenMenu() {
        while (exitApplication) {
            try {
                Header.showMenu();
                menu(chooseMenu());
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    private static void menu(MenuItem chooseMenu) {
        int id;
        switch (chooseMenu) {
            case ADD_CAR:
                carService.create(Add.addCar());
                break;
            case FIND_CAR:
                carService.find(Add.addCar()).stream()
                        .forEach(car -> {
                            Header.displayCar();
                            print.printCarDetails(car);
                        });
                stopLoop();
                break;
            case FIND_BY_ID_CAR:
                id = id();
                Header.displayCar();
                print.printCar(id);
                stopLoop();
                break;
            case UPDATE_CAR:
                Header.displayCar();
                print.printCars();
                carService.update(id(), Add.addCar());
                break;
            case DELETE_CAR:
                Header.displayCar();
                print.printCars();
                carService.remove(id());
                break;
            case SHOW_CAR:
                Header.displayCar();
                print.printCars();
                stopLoop();
                break;
            case ADD_BRAND:
                brandService.create(Add.addBrand());
                break;
            case FIND_BRAND:
                brandService.find(Add.addBrand()).stream().forEach(brand -> {
                    Header.displayBrand();
                    print.printBrandDetails(brand);
                });
                stopLoop();
                break;
            case FIND_BY_ID_BRAND:
                id = id();
                Header.displayBrand();
                print.printBrand(id);
                break;
            case UPDATE_BRAND:
                Header.displayBrand();
                print.printBrands();
                brandService.update(id(), Add.addBrand());
                break;
            case DELETE_BRAND:
                Header.displayBrand();
                print.printBrands();
                brandService.remove(id());
                break;
            case SHOW_BRAND:
                Header.displayBrand();
                print.printBrands();
                stopLoop();
                break;
            case ADD_MODEL:
                modelService.create(Add.addModel());
                break;
            case FIND_MODEL:
                modelService.find(Add.addModel()).stream().forEach(model -> {
                    Header.displayModels();
                    print.printModelDetails(model);
                });
                stopLoop();
                break;
            case FIND_BY_ID_MODEL:
                id = id();
                Header.displayModels();
                print.printModel(id);
                stopLoop();
                break;
            case UPDATE_MODEL:
                Header.displayModels();
                print.printModels(new Model());
                modelService.update(id(), Add.addModel());
                break;
            case DELETE_MODEL:
                Header.displayModels();
                print.printModels(new Model());
                modelService.remove(id());
                break;
            case SHOW_MODEL:
                Header.displayModels();
                print.printModels(new Model());
                stopLoop();
                break;
            case ADD_EMPLOYEE:
                employeeService.create(Add.addEmployee());
                break;
            case FIND_EMPLOYEE:
                employeeService.find(Add.addEmployee()).stream()
                        .forEach(employee -> {
                            Header.displayEmployee();
                            print.printEmployeeDetails(employee);
                        });
                stopLoop();
                break;
            case FIND_BY_ID_EMPLOYEE:
                id = id();
                Header.displayEmployee();
                print.printIdEmployee(id);
                stopLoop();
                break;
            case UPDATE_EMPLOYEE:
                Header.displayEmployee();
                print.printEmployee();
                employeeService.update(id(), Add.addEmployee());
                break;
            case DELETE_EMPLOYEE:
                Header.displayEmployee();
                print.printEmployee();
                employeeService.remove(id());
                break;
            case SHOW_EMPLOYEE:
                Header.displayEmployee();
                print.printEmployee();
                stopLoop();
                break;
            case ADD_CUSTOMER:
                customerService.create(Add.addCustomer());
                break;
            case FIND_CUSTOMER:
                customerService.find(Add.addCustomer()).stream()
                        .forEach(customer -> {
                            Header.displayCustomer();
                            print.printCustomerDetail(customer);
                        });
                stopLoop();
                break;
            case FIND_BY_ID_CUSTOMER:
                id = id();
                Header.displayCustomer();
                print.printCustomer(id);
                stopLoop();
                break;
            case UPDATE_CUSTOMER:
                Header.displayCustomer();
                print.printCustomers();
                customerService.update(id(), Add.addCustomer());
                break;
            case DELETE_CUSTOMER:
                Header.displayCustomer();
                print.printCustomers();
                customerService.remove(id());
                break;
            case SHOW_CUSTOMER:
                Header.displayCustomer();
                print.printCustomers();
                stopLoop();
                break;
            case ADD_RENT:
                rentInformationService.create(Add.addRentInformation());
                break;
            case FIND_RENT:
                rentInformationService.find(Add.addRentInformation()).stream()
                        .forEach(rentInformation -> {
                            Header.displayRentInformation();
                            print.printRentInformationDetails(rentInformation);
                        });
                stopLoop();
                break;
            case FIND_BY_ID_RENT:
                id = id();
                Header.displayRentInformation();
                print.printRentInformation(id);
                stopLoop();
                break;
            case UPDATE_RENT:
                Header.displayRentInformation();
                print.printRentsInformation();
                rentInformationService.update(id(), Add.addRentInformation());
                break;
            case DELETE_RENT:
                Header.displayRentInformation();
                print.printRentsInformation();
                rentInformationService.remove(id());
                break;
            case SHOW_RENT:
                Header.displayRentInformation();
                print.printRentsInformation();
                stopLoop();
                break;
            case EXIT:
                exitApplication = false;
                break;
            default:
                throw new IllegalArgumentException("Wpisales numer z poza listy menu lub wpisales znak");
        }
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
                throw new IllegalArgumentException("Wpisales numer z poza listy menu lub wpisales znak");
        }
    }

    private static void stopLoop() {
        System.out.println("Przycisnij Enter aby wrócić do aplikacji:");
        keyboard.nextLine();
        String continued = keyboard.nextLine();
    }
}
