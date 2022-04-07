package com.ksprogramming.customer;

import com.ksprogramming.CommonRepository;
import com.ksprogramming.CustomerNotFoundException;
import com.ksprogramming.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private Connection connection;
    private CommonRepository commonRepository;


    public CustomerRepository(Connection connection) {
        this.connection = connection;
        this.commonRepository = new CommonRepository(connection);
    }

    public Customer get(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * From customer where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("company_name"),
                        resultSet.getString("tax_number"),
                        resultSet.getString("first_Name"),
                        resultSet.getString("last_Name"),
                        resultSet.getString("pesel"),
                        resultSet.getString("house_number"),
                        resultSet.getString("flat_number"),
                        resultSet.getString("street_name"),
                        resultSet.getString("city"),
                        resultSet.getString("post_code"));
            } else {
                throw new CustomerNotFoundException();
            }
        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }

    }

    public List<Customer> find(Customer customer) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = prepareQuery(customer);
            preparedStatement = connection.prepareStatement(query);
            setParameters(preparedStatement, customer);
            resultSet = preparedStatement.executeQuery();
            return prepareResult(resultSet);

        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
    }

    public Integer create(Customer customer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "Insert into customer(type, company_name, tax_number, first_name, last_name, pesel, house_number, flat_number, street_name, city, post_code) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, customer.getType());
            preparedStatement.setString(2, customer.getCompanyName());
            preparedStatement.setString(3, customer.getTaxNumber());
            preparedStatement.setString(4, customer.getFirstName());
            preparedStatement.setString(5, customer.getLastName());
            preparedStatement.setString(6, customer.getPesel());
            preparedStatement.setString(7, customer.getHouseNumber());
            preparedStatement.setString(8, customer.getFlatNumber());
            preparedStatement.setString(9, customer.getStreetName());
            preparedStatement.setString(10, customer.getCity());
            preparedStatement.setString(11, customer.getPostCode());
            preparedStatement.executeUpdate();
            return commonRepository.getLastInsertedId();
        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        } finally {
            closePreparedStatement(preparedStatement);
        }

    }

    public void update(Integer id, Customer customer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE customer set type = ?, " +
                    "company_name = ?, tax_number = ?, first_name = ?, last_name = ?, pesel = ?, " +
                    "house_number = ?, flat_number = ?, street_name = ?, city = ?, " +
                    "post_code =? WHERE id  = ?;");
            preparedStatement.setString(1, customer.getType());
            preparedStatement.setString(2, customer.getCompanyName());
            preparedStatement.setString(3, customer.getTaxNumber());
            preparedStatement.setString(4, customer.getFirstName());
            preparedStatement.setString(5, customer.getLastName());
            preparedStatement.setString(6, customer.getPesel());
            preparedStatement.setString(7, customer.getHouseNumber());
            preparedStatement.setString(8, customer.getFlatNumber());
            preparedStatement.setString(9, customer.getStreetName());
            preparedStatement.setString(10, customer.getCity());
            preparedStatement.setString(11, customer.getPostCode());
            preparedStatement.setInt(12, id);
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }

    public void remove(Integer id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from customer where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        } finally {
            closePreparedStatement(preparedStatement);
        }
    }

    public void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }
    }

    public void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        }
    }

    public String prepareQuery(Customer customer) {
        String query = "select * from customer where 1=1 ";
        if (customer.getType() != null) {
            query = query + "and type = ?";
        } else if (customer.getCompanyName() != null) {
            query = query + "and company_name = ?";
        } else if (customer.getTaxNumber() != null) {
            query = query + "and tax_number = ?";
        } else if (customer.getFirstName() != null) {
            query = query + "and first_name = ?";
        } else if (customer.getLastName() != null) {
            query = query + "and last_name = ?";
        } else if (customer.getPesel() != null) {
            query = query + "and pesel = ?";
        } else if (customer.getHouseNumber() != null) {
            query = query + "and house_number = ?";
        } else if (customer.getFlatNumber() != null) {
            query = query + "and flat_number = ?";
        } else if (customer.getStreetName() != null) {
            query = query + "and street_name = ?";
        } else if (customer.getCity() != null) {
            query = query + "and city = ?";
        } else if (customer.getPostCode() != null) {
            query = query + "and post_code = ?";
        }

        return query;
    }

    public void setParameters(PreparedStatement preparedStatement, Customer customer) throws SQLException {
        int index = 1;
        if (customer.getType() != null) {
            preparedStatement.setString(index++, customer.getType());
        } else if (customer.getCompanyName() != null) {
            preparedStatement.setString(index++, customer.getCompanyName());
        } else if (customer.getTaxNumber() != null) {
            preparedStatement.setString(index++, customer.getTaxNumber());
        } else if (customer.getFirstName() != null) {
            preparedStatement.setString(index++, customer.getFirstName());
        } else if (customer.getLastName() != null) {
            preparedStatement.setString(index++, customer.getLastName());
        } else if (customer.getPesel() != null) {
            preparedStatement.setString(index++, customer.getPesel());
        } else if (customer.getHouseNumber() != null) {
            preparedStatement.setString(index++, customer.getHouseNumber());
        } else if (customer.getFlatNumber() != null) {
            preparedStatement.setString(index++, customer.getFlatNumber());
        } else if (customer.getStreetName() != null) {
            preparedStatement.setString(index++, customer.getStreetName());
        } else if (customer.getCity() != null) {
            preparedStatement.setString(index++, customer.getCity());
        } else if (customer.getPostCode() != null) {
            preparedStatement.setString(index, customer.getPostCode());
        }
    }

    public List<Customer> prepareResult(ResultSet resultSet) throws SQLException {
        List<Customer> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("type"),
                    resultSet.getString("company_name"),
                    resultSet.getString("tax_number"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("pesel"),
                    resultSet.getString("house_number"),
                    resultSet.getString("flat_number"),
                    resultSet.getString("street_name"),
                    resultSet.getString("city"),
                    resultSet.getString("post_code")));
        }
        return result;
    }
}