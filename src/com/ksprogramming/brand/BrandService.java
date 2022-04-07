package com.ksprogramming.brand;

import java.sql.Connection;
import java.util.List;

public class BrandService {
    private Connection connection;
    private BrandRepository brandRepository;

    public BrandService(Connection connection) {
        this.connection = connection;
        brandRepository = new BrandRepository(connection);
    }

    public Brand getId(Integer id) {
        return brandRepository.getId(id);
    }

    public List<Brand> find(Brand brand) {
        return brandRepository.find(brand);
    }

    public Integer create(Brand brand) {
        return brandRepository.create(brand);
    }

    public void update(int id, Brand brand){
        brandRepository.update(id, brand);
    }

    public void remove(int id){
        brandRepository.remove(id);
    }
}
