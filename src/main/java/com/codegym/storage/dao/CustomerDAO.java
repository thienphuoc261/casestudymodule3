package com.codegym.storage.dao;

import com.codegym.storage.connection.JDBCConnection;
import com.codegym.storage.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {
    private static final String INSERT_CUSTOMER_SQL = "insert into customer (user_id,name,phonenumber) values (?,?,?);";
    public void insertCustomer (Customer customer) throws SQLException {
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setInt(1,customer.getUserID());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
