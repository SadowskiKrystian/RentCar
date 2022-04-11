package com.ksprogramming.rentinformation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentInformation {
    private Integer id;
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

    public RentInformation(Integer id, LocalDateTime rentStart, LocalDateTime rentFinish, Integer employeeId,
                           Integer customerId, String customerType, String customerCompanyName, String customerTaxNumber,
                           String customerFirstName, String customerLastName, String customerPesel, String customerHouseNumber,
                           String customerFlatNumber, String customerStreetName, String customerCity, String customerPostCode,
                           BigDecimal rentNetPrice, BigDecimal rentPercent, BigDecimal rentGrossPrice) {
        this.id = id;
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

    public RentInformation(LocalDateTime rentStart, LocalDateTime rentFinish, Integer employeeId, Integer customerId,
                           String customerType, String customerCompanyName, String customerTaxNumber, String customerFirstName,
                           String customerLastName, String customerPesel, String customerHouseNumber, String customerFlatNumber,
                           String customerStreetName, String customerCity, String customerPostCode, BigDecimal rentNetPrice,
                           BigDecimal rentPercent, BigDecimal rentGrossPrice) {
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
        return "RentInformation{" +
                "id=" + id +
                ", rentStart=" + rentStart +
                ", rentFinish=" + rentFinish +
                ", employeeId=" + employeeId +
                ", customerId=" + customerId +
                ", customerType='" + customerType + '\'' +
                ", customerCompanyName='" + customerCompanyName + '\'' +
                ", customerTaxNumber='" + customerTaxNumber + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerPesel='" + customerPesel + '\'' +
                ", customerHouseNumber='" + customerHouseNumber + '\'' +
                ", customerFlatNumber='" + customerFlatNumber + '\'' +
                ", customerStreetName='" + customerStreetName + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerPostCode='" + customerPostCode + '\'' +
                ", rentNetPrice=" + rentNetPrice +
                ", rentPercent=" + rentPercent +
                ", rentGrossPrice=" + rentGrossPrice +
                '}';
    }
}
