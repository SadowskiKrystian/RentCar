package com.ksprogramming.car;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Car {
    private Integer id;
    private String registrationPlate;
    private String vinNumber;
    private LocalDate purchaseDate;
    private Integer brandId;
    private Integer modelId;

    public Car(Integer id, String registrationPlate, String vinNumber, LocalDate purchaseDate, Integer brandId, Integer modelId) {
        this.id = id;
        this.registrationPlate = registrationPlate;
        this.vinNumber = vinNumber;
        this.purchaseDate = purchaseDate;
        this.brandId = brandId;
        this.modelId = modelId;
    }

    public Car(String registrationPlate, String vinNumber, LocalDate purchaseDate, Integer brandId, Integer modelId) {
        this.registrationPlate = registrationPlate;
        this.vinNumber = vinNumber;
        this.purchaseDate = purchaseDate;
        this.brandId = brandId;
        this.modelId = modelId;
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

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getModelId() {
        return modelId;
    }

    @Override
    public String toString() {
        return id + registrationPlate + vinNumber + purchaseDate + brandId  + modelId;
    }
}
