package com.ksprogramming.employee;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String pesel;
    private String houseNumber;
    private String flatNumber;
    private String streetName;
    private String city;
    private String postCode;

    public Employee(Integer id, String firstName, String lastName, String pesel, String houseNumber, String flatNumber, String streetName, String city, String postCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.streetName = streetName;
        this.city = city;
        this.postCode = postCode;
    }

    public Employee(String firstName, String lastName, String pesel, String houseNumber, String flatNumber, String streetName, String city, String postCode) {
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
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
