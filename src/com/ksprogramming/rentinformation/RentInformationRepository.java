package com.ksprogramming.rentinformation;

import com.ksprogramming.CommonRepository;
import com.ksprogramming.DatabaseException;
import com.ksprogramming.DateTimeUtil;
import com.ksprogramming.car.Car;

import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class RentInformationRepository {
    private Connection connection;
    private CommonRepository commonRepository;


    public RentInformationRepository(Connection connection) {
        this.connection = connection;
        commonRepository = new CommonRepository(connection);
    }

    public RentInformation getId(Integer id){

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("select * from rent_information where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new RentInformation(resultSet.getInt("id"), resultSet.getInt("car_id"), DateTimeUtil.convertToLocalDateTime(resultSet.getDate("rent_start")), DateTimeUtil.convertToLocalDateTime(resultSet.getDate("rent_finish")),
                        resultSet.getInt("employee_id"), resultSet.getInt("customer_id"), resultSet.getString("customer_type"),
                        resultSet.getString("customer_company_name"), resultSet.getString("customer_tax_number"), resultSet.getString("customer_first_name"),
                        resultSet.getString("customer_last_name"), resultSet.getString("customer_pesel"), resultSet.getString("customer_house_number"),
                        resultSet.getString("customer_flat_number"), resultSet.getString("customer_street_name"),
                        resultSet.getString("customer_city"), resultSet.getString("customer_post_code"), resultSet.getBigDecimal("rent_net_price"),
                        resultSet.getBigDecimal("rent_percent"), resultSet.getBigDecimal("rent_gross_price"));
            }
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closeResultsSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
        return null;
    }

    public List<RentInformation> find (RentInformation rentInformation){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = prepareQuery(rentInformation);
            preparedStatement = connection.prepareStatement(query);
            setParameters(preparedStatement, rentInformation);
            resultSet = preparedStatement.executeQuery();
            return prepareResultsSet(resultSet);
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closeResultsSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
    }

    public Integer create (RentInformation rentInformation){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("insert into rent_information(car_id, rent_start, rent_finish, " +
                            "employee_id, customer_id, customer_type, customer_company_name, customer_tax_number, customer_first_name, " +
                            "customer_last_name, customer_pesel, customer_house_number, customer_flat_number, customer_street_name, " +
                            "customer_city, customer_post_code, rent_net_price, rent_percent, rent_gross_price) " + "" +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, rentInformation.getCarId());
            preparedStatement.setTimestamp(2, DateTimeUtil.convertToSqlDateTime(rentInformation.getRentStart()));
            preparedStatement.setTimestamp(3, DateTimeUtil.convertToSqlDateTime(rentInformation.getRentFinish()));
            preparedStatement.setInt(4, rentInformation.getEmployeeId());
            preparedStatement.setInt(5, rentInformation.getCustomerId());
            preparedStatement.setString(6, rentInformation.getCustomerType());
            preparedStatement.setString(7, rentInformation.getCustomerCompanyName());
            preparedStatement.setString(8, rentInformation.getCustomerTaxNumber());
            preparedStatement.setString(9, rentInformation.getCustomerFirstName());
            preparedStatement.setString(10, rentInformation.getCustomerLastName());
            preparedStatement.setString(11, rentInformation.getCustomerPesel());
            preparedStatement.setString(12, rentInformation.getCustomerHouseNumber());
            preparedStatement.setString(13, rentInformation.getCustomerFlatNumber());
            preparedStatement.setString(14, rentInformation.getCustomerStreetName());
            preparedStatement.setString(15, rentInformation.getCustomerCity());
            preparedStatement.setString(16, rentInformation.getCustomerPostCode());
            preparedStatement.setBigDecimal(17, rentInformation.getRentNetPrice());
            preparedStatement.setBigDecimal(18, rentInformation.getRentPercent());
            preparedStatement.setBigDecimal(19, rentInformation.getRentGrossPrice());
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closePreparedStatement(preparedStatement);
        }
        return commonRepository.getLastInsertedId();
    }

    public void update(int id, RentInformation rentInformation){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update car set car_id = ?, rent_start = ?, rent_finish = ?" +
                    "employee_id = ?, customer_id = ?, customer_type = ?, customer_company_name = ?, customer_tax_number = ?, customer_first_name = ?" +
                    "customer_last_name = ?, customer_pesel = ?, customer_house_number = ?, customer_flat_number = ?, customer_street_name = ?" +
                    "customer_city = ?, customer_post_code = ?, rent_net_price = ?, rent_percent = ?, rent_gross_price = ? where id = ?");
            preparedStatement.setInt(1, rentInformation.getCarId());
            preparedStatement.setTimestamp(2, DateTimeUtil.convertToSqlDateTime(rentInformation.getRentStart()));
            preparedStatement.setTimestamp(3, DateTimeUtil.convertToSqlDateTime(rentInformation.getRentFinish()));
            preparedStatement.setInt(4, rentInformation.getEmployeeId());
            preparedStatement.setInt(5, rentInformation.getCustomerId());
            preparedStatement.setString(6, rentInformation.getCustomerType());
            preparedStatement.setString(7, rentInformation.getCustomerCompanyName());
            preparedStatement.setString(8, rentInformation.getCustomerTaxNumber());
            preparedStatement.setString(9, rentInformation.getCustomerFirstName());
            preparedStatement.setString(10, rentInformation.getCustomerLastName());
            preparedStatement.setString(11, rentInformation.getCustomerPesel());
            preparedStatement.setString(12, rentInformation.getCustomerHouseNumber());
            preparedStatement.setString(13, rentInformation.getCustomerFlatNumber());
            preparedStatement.setString(14, rentInformation.getCustomerStreetName());
            preparedStatement.setString(15, rentInformation.getCustomerCity());
            preparedStatement.setString(16, rentInformation.getCustomerPostCode());
            preparedStatement.setBigDecimal(17, rentInformation.getRentNetPrice());
            preparedStatement.setBigDecimal(18, rentInformation.getRentPercent());
            preparedStatement.setBigDecimal(19, rentInformation.getRentGrossPrice());
            preparedStatement.setInt(20, id);
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
            preparedStatement = connection.prepareStatement("delete from rent_information where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }finally {
            closePreparedStatement(preparedStatement);
        }
    }

    private List<RentInformation> prepareResultsSet(ResultSet resultSet) throws SQLException {
        List<RentInformation> addBrand = new ArrayList<>();
        while (resultSet.next()){
            addBrand.add(new RentInformation(resultSet.getInt("id"), resultSet.getInt("car_id"), DateTimeUtil.convertToLocalDateTime(resultSet.getDate("rent_start")), DateTimeUtil.convertToLocalDateTime(resultSet.getDate("rent_finish")),
                    resultSet.getInt("employee_id"), resultSet.getInt("customer_id"), resultSet.getString("customer_type"),
                    resultSet.getString("customer_company_name"), resultSet.getString("customer_tax_number"), resultSet.getString("customer_first_name"),
                    resultSet.getString("customer_last_name"), resultSet.getString("customer_pesel"), resultSet.getString("customer_house_number"),
                    resultSet.getString("customer_flat_number"), resultSet.getString("customer_street_name"),
                    resultSet.getString("customer_city"), resultSet.getString("customer_post_code"), resultSet.getBigDecimal("rent_net_price"),
                    resultSet.getBigDecimal("rent_percent"), resultSet.getBigDecimal("rent_gross_price")));
        }
        return addBrand;
    }

    private void setParameters(PreparedStatement preparedStatement, RentInformation rentInformation) throws SQLException {
        int index = 1;
        if (rentInformation.getCarId() != null){
            preparedStatement.setInt(index++, rentInformation.getCarId());
        }
        if (rentInformation.getRentStart() != null){
            preparedStatement.setTimestamp(index++, DateTimeUtil.convertToSqlDateTime(rentInformation.getRentStart()));
        }
        if (rentInformation.getRentFinish() != null){
            preparedStatement.setTimestamp(index++, DateTimeUtil.convertToSqlDateTime(rentInformation.getRentFinish()));
        }
        if (rentInformation.getEmployeeId() != null){
            preparedStatement.setInt(index++, rentInformation.getEmployeeId());
        }
        if (rentInformation.getCustomerId() != null){
            preparedStatement.setInt(index++, rentInformation.getCustomerId());
        }
        if (rentInformation.getCustomerType() != null){
            preparedStatement.setString(index++, rentInformation.getCustomerType());
        }
        if (rentInformation.getCustomerCompanyName() != null){
            preparedStatement.setString(index++, rentInformation.getCustomerCompanyName());
        }
        if (rentInformation.getCustomerTaxNumber() != null){
            preparedStatement.setString(index++, rentInformation.getCustomerTaxNumber());
        }
        if (rentInformation.getCustomerFirstName() != null){
            preparedStatement.setString(index++, rentInformation.getCustomerFirstName());
        }
        if (rentInformation.getCustomerLastName() != null){
            preparedStatement.setString(index++, rentInformation.getCustomerPesel());
        }
        if (rentInformation.getCustomerHouseNumber() != null){
            preparedStatement.setString(index++, rentInformation.getCustomerHouseNumber());
        }
        if (rentInformation.getCustomerFlatNumber() != null){
            preparedStatement.setString(index++, rentInformation.getCustomerFlatNumber());
        }
        if (rentInformation.getCustomerStreetName() != null){
            preparedStatement.setString(index++, rentInformation.getCustomerStreetName());
        }
        if (rentInformation.getCustomerCity() != null){
            preparedStatement.setString(index++, rentInformation.getCustomerCity());
        }
        if (rentInformation.getCustomerPostCode() != null){
            preparedStatement.setString(index++, rentInformation.getCustomerPostCode());
        }
        if (rentInformation.getRentNetPrice() != null){
            preparedStatement.setBigDecimal(index++, rentInformation.getRentNetPrice());
        }
        if (rentInformation.getRentPercent() != null){
            preparedStatement.setBigDecimal(index++, rentInformation.getRentPercent());
        }
        if (rentInformation.getRentGrossPrice() != null){
            preparedStatement.setBigDecimal(index, rentInformation.getRentGrossPrice());
        }
    }

    private String prepareQuery(RentInformation rentInformation) {
        String query = "select * from rent_information where 1=1 ";
        if (rentInformation.getCarId() != null){
            query = query + "and car_id = ?";
        }
        if (rentInformation.getRentStart() != null){
            query = query + "and rent_start = ?";
        }
        if (rentInformation.getRentFinish() != null){
            query = query + "and rent_finish = ?";
        }
        if (rentInformation.getEmployeeId() != null){
            query = query + "and employee_id = ?";
        }
        if (rentInformation.getCustomerId() != null){
            query = query + "and customer_id = ?";
        }
        if (rentInformation.getCustomerType() != null){
            query = query + "and customer_type = ?";
        }
        if (rentInformation.getCustomerCompanyName() != null){
            query = query + "and customer_company_name = ?";
        }
        if (rentInformation.getCustomerTaxNumber() != null){
            query = query + "and customer_tax_number = ?";
        }
        if (rentInformation.getCustomerFirstName() != null){
            query = query + "and customer_first_name = ?";
        }
        if (rentInformation.getCustomerLastName() != null){
            query = query + "and customer_last_name = ?";
        }
        if (rentInformation.getCustomerHouseNumber() != null){
            query = query + "and customer_house_number = ?";
        }
        if (rentInformation.getCustomerFlatNumber() != null){
            query = query + "and customer_flat_number = ?";
        }
        if (rentInformation.getCustomerStreetName() != null){
            query = query + "and customer_street_name = ?";
        }
        if (rentInformation.getCustomerCity() != null){
            query = query + "and customer_city = ?";
        }
        if (rentInformation.getCustomerPostCode() != null){
            query = query + "and customer_post_code = ?";
        }
        if (rentInformation.getRentNetPrice() != null){
            query = query + "and rent_net_price = ?";
        }
        if (rentInformation.getRentPercent() != null){
            query = query + "and rent_percent = ?";
        }
        if (rentInformation.getRentGrossPrice() != null){
            query = query + "and rent_gross_price = ?";
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
