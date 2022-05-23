package com.ksprogramming.model;

public class Model {
    private Integer id;
    private Integer brandId;
    private String name;

    public Model(Integer id, Integer brandId, String name) {
        this.id = id;
        this.brandId = brandId;
        this.name = name;
    }

    public Model(Integer brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }

    public Model(String name) {
        this.name = name;
    }

    public Model(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + "\t" + brandId + "\t\t\t " + name;
    }
}
