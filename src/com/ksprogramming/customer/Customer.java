package com.ksprogramming.customer;

public class Customer {
    private Integer id;
    private String type;
    private String companyName;
    private String taxNumber;
    private String firstName;
    private String lastName;
    private String pesel;
    private String houseNumber;
    private String flatNumber;
    private String streetName;
    private String city;
    private String postCode;

    public Customer(Integer id, String type, String companyName, String taxNumber, String firstName, String lastName, String pesel, String houseNumber, String flatNumber, String streetName, String city, String postCode) {
        this.id = id;
        this.type = type;
        this.companyName = companyName;
        this.taxNumber = taxNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.streetName = streetName;
        this.city = city;
        this.postCode = postCode;
    }

    public Customer(String type, String companyName, String taxNumber, String firstName, String lastName, String pesel, String houseNumber, String flatNumber, String streetName, String city, String postCode) {
        this.type = type;
        this.companyName = companyName;
        this.taxNumber = taxNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.streetName = streetName;
        this.city = city;
        this.postCode = postCode;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    @Override
    public String toString() {
        return id +
                type +
                companyName +
                taxNumber +
                firstName +
                lastName +
                pesel +
                houseNumber +
                flatNumber +
                streetName +
                city +
                postCode;
    }
}
