package com.ksprogramming.brand;

import com.ksprogramming.CommonRepository;
import com.ksprogramming.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandRepository {
    private Connection connection;
    private CommonRepository commonRepository;

    public BrandRepository(Connection connection) {
        this.connection = connection;
        commonRepository = new CommonRepository(connection);
    }

    public Brand getId(Integer id){

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("select * from brand where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new Brand(resultSet.getInt("id"), resultSet.getString("name"));
            }
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closeResultsSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return null;
    }

    public List<Brand> find (Brand brand){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
           String query = prepareQuery(brand);
           preparedStatement = connection.prepareStatement(query);
           setParameters(preparedStatement, brand);
           resultSet = preparedStatement.executeQuery();
           return prepareResultsSet(resultSet);
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closeResultsSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
    }

    public Integer create (Brand brand){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("insert into brand(name) values (?)");
            preparedStatement.setString(1, brand.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closePreparedStatement(preparedStatement);
        }
        return commonRepository.getLastInsertedId();
    }

    public void update(int id, Brand brand){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update brand set name = ? where id = ?");
            preparedStatement.setString(1, brand.getName());
            preparedStatement.setInt(1, id);
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
            preparedStatement = connection.prepareStatement("delete from brand where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closePreparedStatement(preparedStatement);
        }
    }

    private List<Brand> prepareResultsSet(ResultSet resultSet) throws SQLException {
        List<Brand> addBrand = new ArrayList<>();
        while (resultSet.next()){
            addBrand.add(new Brand(resultSet.getInt("id"), resultSet.getString("name")));
        }
        return addBrand;
    }

    private void setParameters(PreparedStatement preparedStatement, Brand brand) throws SQLException {
        int index = 1;
        if (brand.getName() != null){
            preparedStatement.setString(index, brand.getName());
        }
    }

    private String prepareQuery(Brand brand) {
        String query = "select * from brand where 1=1 ";
        if (brand.getName() != null){
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
