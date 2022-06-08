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

public class Printer {
    private static CustomerService customerService = null;
    private static EmployeeService employeeService = null;
    private static BrandService brandService = null;
    private static ModelService modelService = null;
    private static CarService carService = null;
    private static RentInformationService rentInformationService = null;

    public Printer(CustomerService customerService, EmployeeService employeeService,
                   BrandService brandService, ModelService modelService, CarService carService, RentInformationService rentInformationService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.carService = carService;
        this.rentInformationService = rentInformationService;
    }

    public void printRentsInformation() {
        rentInformationService.find(new RentInformation())
                .stream().forEach(rentInformation -> {
                    printRentInformationDetails(rentInformation);
                });
    }


    public void printRentInformation(Integer id) {
        RentInformation rentInformation = rentInformationService.getId(id);
        if (rentInformation != null) {
            printRentInformationDetails(rentInformation);
        }else{
            printMissingCarMessage("wypożyczeniu");
        }
    }

    public void printRentInformationDetails(RentInformation rentInformation) {
        System.out.printf("%-15s", rentInformation.getId());
        System.out.printf("%-30s", rentInformation.getCar().getRegistrationPlate());
        System.out.printf("%-30s", rentInformation.getRentStart());
        System.out.printf("%-30s", rentInformation.getRentFinish());
        System.out.printf("%-15s", rentInformation.getEmployee().getFirstName());
        System.out.printf("%-15s", rentInformation.getCustomer().getFirstName());
        System.out.printf("%-15s", rentInformation.getCustomerType());
        System.out.printf("%-30s", rentInformation.getCustomerCompanyName());
        System.out.printf("%-15s", rentInformation.getCustomerTaxNumber());
        System.out.printf("%-15s", rentInformation.getCustomerFirstName());
        System.out.printf("%-15s", rentInformation.getCustomerLastName());
        System.out.printf("%-15s", rentInformation.getCustomerPesel());
        System.out.printf("%-15s", rentInformation.getCustomerHouseNumber());
        System.out.printf("%-15s", rentInformation.getCustomerFlatNumber());
        System.out.printf("%-25s", rentInformation.getCustomerStreetName());
        System.out.printf("%-15s", rentInformation.getCustomerCity());
        System.out.printf("%-15s", rentInformation.getCustomerPostCode());
        System.out.printf("%-15s", rentInformation.getRentNetPrice());
        System.out.printf("%-15s", rentInformation.getRentPercent());
        System.out.printf("%-15s", rentInformation.getRentGrossPrice());
        System.out.println("");
    }

    public void printCustomers() {
        customerService.find(new Customer())
                .stream().forEach(customer -> {
                    printCustomerDetail(customer);
                });
    }

    public void printCustomer(Integer id) {
        Customer customer = customerService.getId(id);
        if (customer != null) {
            printCustomerDetail(customer);
        }
    }

    public void printCustomerDetail(Customer customer) {
        System.out.printf("%-15s", customer.getId());
        System.out.printf("%-15s", customer.getType());
        System.out.printf("%-30s", customer.getCompanyName());
        System.out.printf("%-15s", customer.getTaxNumber());
        System.out.printf("%-15s", customer.getFirstName());
        System.out.printf("%-15s", customer.getLastName());
        System.out.printf("%-15s", customer.getPesel());
        System.out.printf("%-15s", customer.getHouseNumber());
        System.out.printf("%-15s", customer.getFlatNumber());
        System.out.printf("%-25s", customer.getStreetName());
        System.out.printf("%-15s", customer.getCity());
        System.out.printf("%-15s", customer.getPostCode());
        System.out.println("");
    }

    public void printEmployee() {
        employeeService.find(new Employee()).stream()
                .forEach(employee -> {
                    printEmployeeDetails(employee);
                });
    }
    public void printIdEmployee(Integer id) {
        Employee employee = employeeService.getId(id);
        if(employee != null) {
            printEmployeeDetails(employee);
        }else{
            printMissingCarMessage("pracowniku");
        }
    }

    public void printEmployeeDetails(Employee employee) {
        System.out.printf("%-15s", employee.getId());
        System.out.printf("%-15s", employee.getFirstName());
        System.out.printf("%-15s", employee.getLastName());
        System.out.printf("%-15s", employee.getPesel());
        System.out.printf("%-15s", employee.getHouseNumber());
        System.out.printf("%-15s", employee.getFlatNumber());
        System.out.printf("%-25s", employee.getStreetName());
        System.out.printf("%-15s", employee.getCity());
        System.out.printf("%-15s", employee.getPostCode());
        System.out.println("");
    }

    public void printCars() {
        carService.find(new Car())
                .stream().forEach(text -> {
                    printCarDetails(text);
                });
    }

    public void printCar(Integer id) {
        Car car = carService.get(id);
        if (car != null) {
            printCarDetails(car);
        }else{
            printMissingCarMessage("samochodzie");
        }
    }



    public void printCarDetails(Car car) {
        System.out.printf("%-5s", car.getId());
        System.out.printf("%-15s", car.getRegistrationPlate());
        System.out.printf("%-30s", car.getVinNumber());
        System.out.printf("%-15s", car.getPurchaseDate());
        System.out.printf("%-15s", car.getBrand().getName());
        System.out.printf("%-15s", car.getModel().getName());
        System.out.println("");
    }

    public void printBrands() {
        brandService.find(new Brand()).stream()
                .forEach(brand -> {
                    printBrandDetails(brand);
                });
    }

    public void printBrand(Integer id) {
        Brand brand = brandService.getId(id);
        if (brand != null) {
            printBrandDetails(brand);
        }else{
            printMissingCarMessage("marce");
        }
    }

    public void printBrandDetails(Brand brand) {
        System.out.printf("%-15s", brand.getId());
        System.out.printf("%-15s", brand.getName());
        System.out.println("");
    }

    public void printModels(Model model) {
        if (model.getBrand() != null) {
            modelService.find(new Model(new Brand(model.getBrand().getId()))).stream()
                    .forEach(modelBrand -> {
                        printModelDetails(modelBrand);
                    });
        } else {
            modelService.find(new Model()).stream()
                    .forEach(modelBrand -> {
                        printModelDetails(modelBrand);
                    });
        }
    }
    public void printModel(Integer id){
        Model model = modelService.getId(id);
        if (model != null) {
            printModelDetails(model);
        }else{
            printMissingCarMessage("modelu");
        }
    }

    public void printModelDetails(Model model) {
        System.out.printf("%-15s", model.getId());
        System.out.printf("%-15s", model.getBrand().getName());
        System.out.printf("%-15s", model.getName());
        System.out.println("");
    }

    private void printMissingCarMessage(String name) {
        System.out.println("Brak danych o " + name + " o podanym id.");
    }
}
