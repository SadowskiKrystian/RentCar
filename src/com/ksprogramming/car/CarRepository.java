package com.ksprogramming.car;

import com.ksprogramming.CommonRepository;
import com.ksprogramming.DatabaseException;
import com.ksprogramming.DateTimeUtil;
import com.ksprogramming.brand.Brand;
import com.ksprogramming.model.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private Connection connection;
    private CommonRepository commonRepository;

    public CarRepository(Connection connection) {
        this.connection = connection;
        this.commonRepository = new CommonRepository(connection);
    }

    public Car get(Integer id){

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("select * from car as c " +
                    "join brand as b on c.brand_id = b.id " +
                    "join model as m on b.id  = m.brand_id " +
                    "where c.id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new Car(resultSet.getInt("c.id"), resultSet.getString("registration_plate"),
                        resultSet.getString("vin_number"), resultSet.getDate("purchase_date").toLocalDate(),
                        new Brand(resultSet.getString("b.name")), new Model(resultSet.getString("m.name")));
            }
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closeResultsSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return null;
    }

    public List<Car> find (Car car){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = prepareQuery(car);
            preparedStatement = connection.prepareStatement(query);
            setParameters(preparedStatement, car);
            resultSet = preparedStatement.executeQuery();
            return prepareResultsSet(resultSet);
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closeResultsSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
    }

    public Integer create (Car car){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("insert into car(registration_plate, vin_number," +
                    " purchase_date, brand_id, model_id) values (?, ?, ? ,?, ?)");
            preparedStatement.setString(1, car.getRegistrationPlate());
            preparedStatement.setString(2, car.getVinNumber());
            preparedStatement.setDate(3, java.sql.Date.valueOf(car.getPurchaseDate()));
            preparedStatement.setInt(4, car.getBrand().getId());
            preparedStatement.setInt(5, car.getModel().getId());
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closePreparedStatement(preparedStatement);
        }
        return commonRepository.getLastInsertedId();
    }

    public void update(int id, Car car){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update car set registration_plate = ?, vin_number = ?," +
                    " purchase_date = ?, brand_id = ?, model_id = ? where id = ?");
            preparedStatement.setString(1, car.getRegistrationPlate());
            preparedStatement.setString(2, car.getVinNumber());
            preparedStatement.setDate(3, DateTimeUtil.convertToLocalDate(car.getPurchaseDate()));
            preparedStatement.setInt(4, car.getBrand().getId());
            preparedStatement.setInt(5, car.getModel().getId());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closePreparedStatement(preparedStatement);
        }
    }

    public void remove(int id){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from car where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closePreparedStatement(preparedStatement);
        }
    }

    private List<Car> prepareResultsSet(ResultSet resultSet) throws SQLException {
        List<Car> addBrand = new ArrayList<>();
            while (resultSet.next()) {
                addBrand.add(new Car(resultSet.getInt("c.id"), resultSet.getString("registration_plate"),
                        resultSet.getString("vin_number"), resultSet.getDate("purchase_date").toLocalDate(),
                        new Brand(resultSet.getString("b.name")), new Model(resultSet.getString("m.name"))));
            }
            return addBrand;
    }

    private void setParameters(PreparedStatement preparedStatement, Car car) throws SQLException {
        int index = 1;
        if (car.getRegistrationPlate() != null){
            preparedStatement.setString(index++, car.getRegistrationPlate());
        }
        if (car.getVinNumber() != null){
            preparedStatement.setString(index++, car.getVinNumber());
        }
        if (car.getPurchaseDate() != null){
            preparedStatement.setDate(index++, java.sql.Date.valueOf(car.getPurchaseDate()));
        }
        if (car.getBrand() != null && car.getBrand().getId() != null){
            preparedStatement.setInt(index++, car.getBrand().getId());
        }
        if (car.getModel() != null && car.getModel().getId() != null){
            preparedStatement.setInt(index, car.getModel().getId());
        }
    }

    private String prepareQuery(Car car) {
        String query = "select * from car as c " +
                "join brand as b on c.brand_id = b.id " +
                "join model as m on b.id  = m.brand_id " +
                "where 1=1 ";
        if (car.getRegistrationPlate() != null){
            query = query + "and registration_plate = ?";
        }
        if(car.getVinNumber() != null){
            query = query + "and vin_number = ?";
        }
        if (car.getPurchaseDate() != null){
            query = query + "and purchase_date = ?";
        }
        if (car.getBrand() != null && car.getBrand().getId() != null){
            query = query = "and brand_id = ?";
        }
        if (car.getModel() != null && car.getModel().getId() != null){
            query = query + "and model_id = ?";
        }
        return query;
    }

    public void closePreparedStatement(PreparedStatement preparedStatement){
        try{
            preparedStatement.close();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(),sqlException);
        }
    }

    public void closeResultsSet(ResultSet resultSet){
        try{
            resultSet.close();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(),sqlException);
        }
    }
}
