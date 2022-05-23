package com.ksprogramming.rentinformation;

import com.ksprogramming.car.Car;
import com.ksprogramming.customer.Customer;
import com.ksprogramming.employee.Employee;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentInformation {
    private Integer id;
    private Car car;
    private LocalDateTime rentStart;
    private LocalDateTime rentFinish;
    private Employee employee;
    private Customer customer;
    private String customerType;
    private String customerCompanyName;
    private String customerTaxNumber;
    private String customerFirstName;
    private String customerLastName;
    private String customerPesel;
    private String customerHouseNumber;
    private String customerFlatNumber;
    private String customerStreetName;
    private String customerCity;
    private String customerPostCode;
    private BigDecimal rentNetPrice;
    private BigDecimal rentPercent;
    private BigDecimal rentGrossPrice;

    public RentInformation(Integer id, Car car, LocalDateTime rentStart, LocalDateTime rentFinish,
                           Employee employee, Customer customer, String customerType, String customerCompanyName,
                           String customerTaxNumber, String customerFirstName, String customerLastName,
                           String customerPesel, String customerHouseNumber, String customerFlatNumber,
                           String customerStreetName, String customerCity, String customerPostCode,
                           BigDecimal rentNetPrice, BigDecimal rentPercent, BigDecimal rentGrossPrice) {
        this.id = id;
        this.car = car;
        this.rentStart = rentStart;
        this.rentFinish = rentFinish;
        this.employee = employee;
        this.customer = customer;
        this.customerType = customerType;
        this.customerCompanyName = customerCompanyName;
        this.customerTaxNumber = customerTaxNumber;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerPesel = customerPesel;
        this.customerHouseNumber = customerHouseNumber;
        this.customerFlatNumber = customerFlatNumber;
        this.customerStreetName = customerStreetName;
        this.customerCity = customerCity;
        this.customerPostCode = customerPostCode;
        this.rentNetPrice = rentNetPrice;
        this.rentPercent = rentPercent;
        this.rentGrossPrice = rentGrossPrice;
    }

    public RentInformation(Car car, LocalDateTime rentStart, LocalDateTime rentFinish, Employee employee,
                           Customer customer, String customerType, String customerCompanyName, String customerTaxNumber,
                           String customerFirstName, String customerLastName, String customerPesel,
                           String customerHouseNumber, String customerFlatNumber, String customerStreetName,
                           String customerCity, String customerPostCode, BigDecimal rentNetPrice,
                           BigDecimal rentPercent, BigDecimal rentGrossPrice) {
        this.car = car;
        this.rentStart = rentStart;
        this.rentFinish = rentFinish;
        this.employee = employee;
        this.customer = customer;
        this.customerType = customerType;
        this.customerCompanyName = customerCompanyName;
        this.customerTaxNumber = customerTaxNumber;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerPesel = customerPesel;
        this.customerHouseNumber = customerHouseNumber;
        this.customerFlatNumber = customerFlatNumber;
        this.customerStreetName = customerStreetName;
        this.customerCity = customerCity;
        this.customerPostCode = customerPostCode;
        this.rentNetPrice = rentNetPrice;
        this.rentPercent = rentPercent;
        this.rentGrossPrice = rentGrossPrice;
    }

    public Integer getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public LocalDateTime getRentStart() {
        return rentStart;
    }

    public LocalDateTime getRentFinish() {
        return rentFinish;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getCustomerCompanyName() {
        return customerCompanyName;
    }

    public String getCustomerTaxNumber() {
        return customerTaxNumber;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerPesel() {
        return customerPesel;
    }

    public String getCustomerHouseNumber() {
        return customerHouseNumber;
    }

    public String getCustomerFlatNumber() {
        return customerFlatNumber;
    }

    public String getCustomerStreetName() {
        return customerStreetName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public String getCustomerPostCode() {
        return customerPostCode;
    }

    public BigDecimal getRentNetPrice() {
        return rentNetPrice;
    }

    public BigDecimal getRentPercent() {
        return rentPercent;
    }

    public BigDecimal getRentGrossPrice() {
        return rentGrossPrice;
    }

    @Override
    public String toString() {
        return  id + "" +
                car +
                rentStart +
                rentFinish +
                employee +
                customer +
                customerType +
                customerCompanyName +
                customerTaxNumber +
                customerFirstName +
                customerLastName +
                customerPesel +
                customerHouseNumber +
                customerFlatNumber +
                customerStreetName +
                customerCity +
                customerPostCode +
                rentNetPrice +
                rentPercent +
                rentGrossPrice;
    }
}
