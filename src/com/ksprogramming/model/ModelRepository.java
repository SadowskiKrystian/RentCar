package com.ksprogramming.model;

import com.ksprogramming.CommonRepository;
import com.ksprogramming.DatabaseException;
import com.ksprogramming.brand.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelRepository {
    private Connection connection;
    private CommonRepository commonRepository;

    public ModelRepository(Connection connection) {
        this.connection = connection;
        commonRepository = new CommonRepository(connection);
    }

    public Model getId(Integer id){

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("select * from model where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new Model(resultSet.getInt("id"), resultSet.getInt("brand_id"), resultSet.getString("name"));
            }
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closeResultsSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return null;
    }

    public List<Model> find (Model model){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = prepareQuery(model);
            preparedStatement = connection.prepareStatement(query);
            setParameters(preparedStatement, model);
            resultSet = preparedStatement.executeQuery();
            return prepareResultsSet(resultSet);
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closeResultsSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
    }

    public Integer create (Model model){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("insert into model(brand_id, name) values (?, ?)");
            preparedStatement.setInt(1, model.getBrandId());
            preparedStatement.setString(2, model.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closePreparedStatement(preparedStatement);
        }
        return commonRepository.getLastInsertedId();
    }

    public void update(int id, Model model){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update model set brand_id = ?, name = ? where id = ?");
            preparedStatement.setInt(1, model.getBrandId());
            preparedStatement.setString(2, model.getName());
            preparedStatement.setInt(3, id);
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
            preparedStatement = connection.prepareStatement("delete from model where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closePreparedStatement(preparedStatement);
        }
    }

    private List<Model> prepareResultsSet(ResultSet resultSet) throws SQLException {
        List<Model> addBrand = new ArrayList<>();
        while (resultSet.next()){
            addBrand.add(new Model(resultSet.getInt("id"), resultSet.getInt("brand_id"), resultSet.getString("name")));
        }
        return addBrand;
    }

    private void setParameters(PreparedStatement preparedStatement, Model model) throws SQLException {
        int index = 1;
        if (model.getBrandId() != null) {
            preparedStatement.setInt(index++, model.getBrandId());
        }
        if (model.getName() != null){
            preparedStatement.setString(index, model.getName());
        }
    }

    private String prepareQuery(Model model) {
        String query = "select * from model where 1=1 ";
        if (model.getBrandId() != null) {
            query = query + "and brand_id = ?";
        }
        if (model.getName() != null){
            query = query + "and name = ?";
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

