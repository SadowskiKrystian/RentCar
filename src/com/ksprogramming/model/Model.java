package com.ksprogramming.model;

import com.ksprogramming.brand.Brand;

public class Model {
    private Integer id;
    private Brand brand;
    private String name;

    public Model() {
    }

    public Model(Integer id, Brand brand, String name) {
        this.id = id;
        this.brand = brand;
        this.name = name;
    }

    public Model(String name) {
        this.name = name;
    }

    public Model(Brand brand) {
        this.brand = brand;
    }

    public Model(Brand brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public Model(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + brand.getName() + name;
    }
}
