package com.ksprogramming.employee;

import com.ksprogramming.CommonRepository;
import com.ksprogramming.CustomerNotFoundException;
import com.ksprogramming.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private Connection connection;
    private CommonRepository commonRepository;

    public EmployeeRepository(Connection connection) {
        this.connection = connection;
        commonRepository = new CommonRepository(connection);
    }

    public Employee getId(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select * From employee where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
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

    public List<Employee> find(Employee employee) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String query = prepareQuery(employee);
            preparedStatement = connection.prepareStatement(query);
            setParameters(preparedStatement, employee);
            resultSet = preparedStatement.executeQuery();
            return prepareResult(resultSet);

        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        } finally {
            closeResultSet(resultSet);
            closePreparedStatement(preparedStatement);
        }
    }

    public Integer create(Employee employee) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "Insert into employee(first_name, last_name, pesel, house_number, flat_number, street_name, city, post_code) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getPesel());
            preparedStatement.setString(4, employee.getHouseNumber());
            preparedStatement.setString(5, employee.getFlatNumber());
            preparedStatement.setString(6, employee.getStreetName());
            preparedStatement.setString(7, employee.getCity());
            preparedStatement.setString(8, employee.getPostCode());
            preparedStatement.executeUpdate();
            return commonRepository.getLastInsertedId();
        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException.getMessage(), sqlException);
        } finally {
            closePreparedStatement(preparedStatement);
        }

    }

    public void update(Integer id, Employee employee) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE employee set first_name = ?, " +
                    "last_name = ?, pesel = ?, house_number = ?, flat_number = ?, street_name = ?, " +
                    "city = ?, post_code = ? WHERE id  = ?;");
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getPesel());
            preparedStatement.setString(4, employee.getHouseNumber());
            preparedStatement.setString(5, employee.getFlatNumber());
            preparedStatement.setString(6, employee.getStreetName());
            preparedStatement.setString(7, employee.getCity());
            preparedStatement.setString(8, employee.getPostCode());
            preparedStatement.setInt(9, id);
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
            preparedStatement = connection.prepareStatement("delete from employee where id = ?");
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

    public String prepareQuery(Employee employee) {
        String query = "select * from employee where 1=1 ";
        if (employee.getFirstName() != null) {
            query = query + "and first_name = ?";
        } else if (employee.getLastName() != null) {
            query = query + "and last_name = ?";
        } else if (employee.getPesel() != null) {
            query = query + "and pesel = ?";
        } else if (employee.getHouseNumber() != null) {
            query = query + "and house_number = ?";
        } else if (employee.getFlatNumber() != null) {
            query = query + "and flat_number = ?";
        } else if (employee.getStreetName() != null) {
            query = query + "and street_name = ?";
        } else if (employee.getCity() != null) {
            query = query + "and city = ?";
        } else if (employee.getPostCode() != null) {
            query = query + "and post_code = ?";
        }
        return query;
    }

    public void setParameters(PreparedStatement preparedStatement, Employee employee) throws SQLException {
        int index = 1;
        if (employee.getFirstName() != null) {
            preparedStatement.setString(index++, employee.getFirstName());
        } else if (employee.getLastName() != null) {
            preparedStatement.setString(index++, employee.getLastName());
        } else if (employee.getPesel() != null) {
            preparedStatement.setString(index++, employee.getPesel());
        } else if (employee.getHouseNumber() != null) {
            preparedStatement.setString(index++, employee.getHouseNumber());
        } else if (employee.getFlatNumber() != null) {
            preparedStatement.setString(index++, employee.getFlatNumber());
        } else if (employee.getStreetName() != null) {
            preparedStatement.setString(index++, employee.getStreetName());
        } else if (employee.getCity() != null) {
            preparedStatement.setString(index++, employee.getCity());
        } else if (employee.getPostCode() != null) {
            preparedStatement.setString(index++, employee.getPostCode());
        }
    }

    public List<Employee> prepareResult(ResultSet resultSet) throws SQLException {
        List<Employee> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Employee(
                    resultSet.getInt("id"),
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
