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

public class Print {
    private static CustomerService customerService = null;
    private static EmployeeService employeeService = null;
    private static BrandService brandService = null;
    private static ModelService modelService = null;
    private static CarService carService = null;
    private static RentInformationService rentInformationService = null;

    public Print(CustomerService customerService, EmployeeService employeeService,
                 BrandService brandService, ModelService modelService, CarService carService, RentInformationService rentInformationService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.carService = carService;
        this.rentInformationService = rentInformationService;
    }

    public void printRentInformation() {
        rentInformationService.find(new RentInformation(null, null, null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null, null, null))
                .stream().forEach(text -> {
                    System.out.printf("%-15s", text.getId());
                    System.out.printf("%-15s", text.getCar().getNameBrand().getName());
                    System.out.printf("%-30s", text.getRentStart());
                    System.out.printf("%-30s", text.getRentFinish());
                    System.out.printf("%-15s", text.getEmployee().getFirstName());
                    System.out.printf("%-15s", text.getCustomer().getFirstName());
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

    public void printIdRentInformation(Integer id) {
                    System.out.printf("%-15s", rentInformationService.getId(id));
                    System.out.printf("%-15s", rentInformationService.getId(id).getCar().getNameBrand().getName());
                    System.out.printf("%-30s", rentInformationService.getId(id).getRentStart());
                    System.out.printf("%-30s", rentInformationService.getId(id).getRentFinish());
                    System.out.printf("%-15s", rentInformationService.getId(id).getEmployee().getFirstName());
                    System.out.printf("%-15s", rentInformationService.getId(id).getCustomer().getFirstName());
                    System.out.printf("%-15s", rentInformationService.getId(id).getCustomerType());
                    System.out.printf("%-30s", rentInformationService.getId(id).getCustomerCompanyName());
                    System.out.printf("%-15s", rentInformationService.getId(id).getCustomerTaxNumber());
                    System.out.printf("%-15s", rentInformationService.getId(id).getCustomerFirstName());
                    System.out.printf("%-15s", rentInformationService.getId(id).getCustomerLastName());
                    System.out.printf("%-15s", rentInformationService.getId(id).getCustomerPesel());
                    System.out.printf("%-15s", rentInformationService.getId(id).getCustomerHouseNumber());
                    System.out.printf("%-15s", rentInformationService.getId(id).getCustomerFlatNumber());
                    System.out.printf("%-25s", rentInformationService.getId(id).getCustomerStreetName());
                    System.out.printf("%-15s", rentInformationService.getId(id).getCustomerCity());
                    System.out.printf("%-15s", rentInformationService.getId(id).getCustomerPostCode());
                    System.out.println("");
    }

    public void printCustomer() {
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

    public void printIdCustomer(Integer id) {
                    System.out.printf("%-15s", customerService.getId(id).getId());
                    System.out.printf("%-15s", customerService.getId(id).getType());
                    System.out.printf("%-30s", customerService.getId(id).getCompanyName());
                    System.out.printf("%-15s", customerService.getId(id).getTaxNumber());
                    System.out.printf("%-15s", customerService.getId(id).getFirstName());
                    System.out.printf("%-15s", customerService.getId(id).getLastName());
                    System.out.printf("%-15s", customerService.getId(id).getPesel());
                    System.out.printf("%-15s", customerService.getId(id).getHouseNumber());
                    System.out.printf("%-15s", customerService.getId(id).getFlatNumber());
                    System.out.printf("%-25s", customerService.getId(id).getStreetName());
                    System.out.printf("%-15s", customerService.getId(id).getCity());
                    System.out.printf("%-15s", customerService.getId(id).getPostCode());
                    System.out.println("");
    }

    public void printEmployee() {
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
    public void printIdEmployee(Integer id) {
                    System.out.printf("%-15s", employeeService.getId(id).getCity());
                    System.out.printf("%-15s", employeeService.getId(id).getFirstName());
                    System.out.printf("%-15s", employeeService.getId(id).getLastName());
                    System.out.printf("%-15s", employeeService.getId(id).getPesel());
                    System.out.printf("%-15s", employeeService.getId(id).getHouseNumber());
                    System.out.printf("%-15s", employeeService.getId(id).getFlatNumber());
                    System.out.printf("%-25s", employeeService.getId(id).getStreetName());
                    System.out.printf("%-15s", employeeService.getId(id).getCity());
                    System.out.printf("%-15s", employeeService.getId(id).getPostCode());
                    System.out.println("");

    }

    public void printCar() {
        carService.find(new Car(null, null, null, null, null))
                .stream().forEach(text -> {
                    System.out.printf("%-5s", text.getId());
                    System.out.printf("%-15s", text.getRegistrationPlate());
                    System.out.printf("%-30s", text.getVinNumber());
                    System.out.printf("%-15s", text.getPurchaseDate());
                    System.out.printf("%-15s", text.getNameBrand().getName());
                    System.out.printf("%-15s", text.getNameModel().getName());
                    System.out.println("");
                });
    }

    public void printIdCar(Integer id) {
        System.out.printf("%-5s", carService.getId(id).getId());
        System.out.printf("%-15s", carService.getId(id).getRegistrationPlate());
        System.out.printf("%-30s", carService.getId(id).getVinNumber());
        System.out.printf("%-15s", carService.getId(id).getPurchaseDate());
        System.out.printf("%-15s", carService.getId(id).getNameBrand().getName());
        System.out.printf("%-15s", carService.getId(id).getNameModel().getName());
        System.out.println("");
    }

    public void printBrand() {
        brandService.find(new Brand()).stream()
                .forEach(brand -> {
                    System.out.printf("%-15s", brand.getId());
                    System.out.printf("%-15s", brand.getName());
                    System.out.println("");
                });
    }

    public void printIdBrand(Integer id) {
        System.out.printf("%-15s", brandService.getId(id).getId());
        System.out.printf("%-15s", brandService.getId(id).getName());
        System.out.println("");
    }

    public void printModels(Model model) {
        if (model.getBrand() != null) {
            modelService.find(new Model(new Brand(model.getBrand().getId()))).stream()
                    .forEach(modelBrand -> {
                        System.out.printf("%-15s", modelBrand.getId());
                        System.out.printf("%-15s", modelBrand.getBrand().getName());
                        System.out.printf("%-15s", modelBrand.getName());
                        System.out.println("");
                    });
        } else {
            modelService.find(new Model()).stream()
                    .forEach(modelBrand -> {
                        System.out.printf("%-15s", modelBrand.getId());
                        System.out.printf("%-15s", modelBrand.getBrand().getName());
                        System.out.printf("%-15s", modelBrand.getName());
                        System.out.println("");
                    });
        }
    }
    public void printIdModel(Integer id){
        System.out.printf("%-15s", modelService.getId(id).getId());
        System.out.printf("%-15s", modelService.getId(id).getBrand().getName());
        System.out.printf("%-15s", modelService.getId(id).getName());
        System.out.println("");
    }
}
