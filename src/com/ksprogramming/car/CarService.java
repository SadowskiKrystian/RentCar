package com.ksprogramming.car;

import java.sql.Connection;
import java.util.List;

public class CarService {
    private Connection connection;
    private CarRepository carRepository;

    public CarService(Connection connection) {
        this.connection = connection;
        carRepository = new CarRepository(connection);
    }

    public Car getId(Integer id){
        return carRepository.get(id);
    }
    public List<Car> find(Car car){
        return carRepository.find(car);
    }
    public Integer create(Car car){
        return carRepository.create(car);
    }
    public void update(Integer id, Car car){
        carRepository.update(id, car);
    }
    public void remove(Integer id){
        carRepository.remove(id);
    }
}
