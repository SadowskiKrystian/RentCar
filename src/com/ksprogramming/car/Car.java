package com.ksprogramming.car;

import com.ksprogramming.brand.Brand;
import com.ksprogramming.model.Model;

import java.time.LocalDate;

public class Car{
    private Integer id;
    private String registrationPlate;
    private String vinNumber;
    private LocalDate purchaseDate;
    private Brand brand;
    private Model model;

    public Car() {
    }

    public Car(Integer id, String registrationPlate, String vinNumber, LocalDate purchaseDate, Brand brand, Model model) {
        this.id = id;
        this.registrationPlate = registrationPlate;
        this.vinNumber = vinNumber;
        this.purchaseDate = purchaseDate;
        this.brand = brand;
        this.model = model;
    }

    public Car(String registrationPlate, String vinNumber, LocalDate purchaseDate, Brand brand, Model model) {
        this.registrationPlate = registrationPlate;
        this.vinNumber = vinNumber;
        this.purchaseDate = purchaseDate;
        this.brand = brand;
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model getModel() {
        return model;
    }

    public Integer getId() {
        return id;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", registrationPlate='" + registrationPlate + '\'' +
                ", vinNumber='" + vinNumber + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", brand=" + brand +
                ", model=" + model +
                '}';
    }
}
