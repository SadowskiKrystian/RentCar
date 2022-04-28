package com.ksprogramming.rentinformation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentInformation {
    private Integer id;
    private Integer carId;
    private LocalDateTime rentStart;
    private LocalDateTime rentFinish;
    private Integer employeeId;
    private Integer customerId;
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

    public RentInformation(Integer id, Integer carId, LocalDateTime rentStart, LocalDateTime rentFinish, Integer employeeId,
                           Integer customerId, String customerType, String customerCompanyName, String customerTaxNumber,
                           String customerFirstName, String customerLastName, String customerPesel, String customerHouseNumber,
                           String customerFlatNumber, String customerStreetName, String customerCity, String customerPostCode,
                           BigDecimal rentNetPrice, BigDecimal rentPercent, BigDecimal rentGrossPrice) {
        this.id = id;
        this.carId = carId;
        this.rentStart = rentStart;
        this.rentFinish = rentFinish;
        this.employeeId = employeeId;
        this.customerId = customerId;
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

    public RentInformation(Integer carId, LocalDateTime rentStart, LocalDateTime rentFinish, Integer employeeId, Integer customerId,
                           String customerType, String customerCompanyName, String customerTaxNumber, String customerFirstName,
                           String customerLastName, String customerPesel, String customerHouseNumber, String customerFlatNumber,
                           String customerStreetName, String customerCity, String customerPostCode, BigDecimal rentNetPrice,
                           BigDecimal rentPercent, BigDecimal rentGrossPrice) {
        this.carId = carId;
        this.rentStart = rentStart;
        this.rentFinish = rentFinish;
        this.employeeId = employeeId;
        this.customerId = customerId;
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

    public Integer getCarId() {
        return carId;
    }

    public LocalDateTime getRentStart() {
        return rentStart;
    }

    public LocalDateTime getRentFinish() {
        return rentFinish;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Integer getCustomerId() {
        return customerId;
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
        return id + carId +
                 "" + rentStart +
                rentFinish +
                employeeId +
                customerId +
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
