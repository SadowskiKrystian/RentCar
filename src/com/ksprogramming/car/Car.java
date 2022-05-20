package com.ksprogramming.car;

import com.ksprogramming.brand.Brand;
import com.ksprogramming.model.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Car{
    private Integer id;
    private String registrationPlate;
    private String vinNumber;
    private LocalDate purchaseDate;
    private Brand nameBrand;
    private Model nameModel;

    public Car() {
    }

    public Car(Integer id, String registrationPlate, String vinNumber, LocalDate purchaseDate, Brand nameBrand, Model nameModel) {
        this.id = id;
        this.registrationPlate = registrationPlate;
        this.vinNumber = vinNumber;
        this.purchaseDate = purchaseDate;
        this.nameBrand = nameBrand;
        this.nameModel = nameModel;
    }

    public Car(String registrationPlate, String vinNumber, LocalDate purchaseDate, Brand nameBrand, Model nameModel) {
        this.registrationPlate = registrationPlate;
        this.vinNumber = vinNumber;
        this.purchaseDate = purchaseDate;
        this.nameBrand = nameBrand;
        this.nameModel = nameModel;
    }

    public Car(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public Car(Integer id) {
        this.id = id;
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

    public Brand getNameBrand() {
        return nameBrand;
    }

    public Model getNameModel() {
        return nameModel;
    }

    @Override
    public String toString() {
        return id + registrationPlate + vinNumber + purchaseDate + nameBrand.getName() + nameModel.getName();
    }
}
