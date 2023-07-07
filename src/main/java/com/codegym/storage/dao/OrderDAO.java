package com.codegym.storage.dao;

import com.codegym.storage.connection.JDBCConnection;
import com.codegym.storage.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static final String INSERT_ORDER_SQL = "insert into `order` (user_id,order_date,destination,message,isDelivered,total_price) values (?,?,?,?,?,?);";
    private static final String SELECT_ALL_ORDERS = "select * from `order` where is_delete = false;";
    private static final String SELECT_ALL_ORDERS_BY_USERID = "select * from `order` where is_delete = false and user_id = ?;";
    private static final String UPDATE_ORDER = "update `order` set order_date = ?, destination = ?, message = ? where id = ?;";
    private static final String SELECT_ORDER_BY_USERID = "select * from `order` where user_id = ?;";
    public void insertOrder(Order order) throws SQLException {
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL);
            preparedStatement.setInt(1,order.getUserId());
            preparedStatement.setString(2, order.getOrderDate());
            preparedStatement.setString(3,order.getDestination());
            preparedStatement.setString(4,order.getMessage());
            preparedStatement.setBoolean(5,order.getIsDelevered());
            preparedStatement.setInt(6,order.getTotalPrice());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Order> selectAllOrders() throws SQLException{
        List<Order> orderList = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                boolean isConfirmed = Boolean.parseBoolean("is_confirmed");
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                String orderDate = resultSet.getString("order_date");
                String destination = resultSet.getString("destination");
                String message = resultSet.getString("message");
                boolean isDelivered = resultSet.getBoolean("isDelivered");
                int totalprice = resultSet.getInt("total_price");
                Order order = new Order(id,user_id,orderDate,destination,message,isDelivered,isConfirmed,totalprice);
                orderList.add(order);
                preparedStatement.close();
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }
    public List<Order> selectOrdersByUserId(int id) throws SQLException{
        List<Order> orderList = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS_BY_USERID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                boolean isConfirmed = Boolean.parseBoolean("is_confirmed");
                int ID = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                String orderDate = resultSet.getString("order_date");
                String destination = resultSet.getString("destination");
                String message = resultSet.getString("message");
                boolean isDelivered = resultSet.getBoolean("isDelivered");
                int totalprice = resultSet.getInt("total_price");
                Order order = new Order(ID,user_id,orderDate,destination,message,isDelivered,isConfirmed,totalprice);
                orderList.add(order);
                preparedStatement.close();
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public boolean updateOrder (String orderDate,String destination, String message, int id) throws SQLException {
        boolean rowUpdate = false;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER);
            preparedStatement.setString(1,orderDate);
            preparedStatement.setString(2,destination);
            preparedStatement.setString(3,message);
            preparedStatement.setInt(4,id);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    public Order getOrderByUserId(int id) throws SQLException {
        Order order = null;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS_BY_USERID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int orderId = resultSet.getInt("id");
                String orderDate = resultSet.getString("order_date");
                String destination = resultSet.getString("destination");
                String message = resultSet.getString("message");
                boolean isDelivered = resultSet.getBoolean("isDelivered");
                boolean isConfirmed = resultSet.getBoolean("is_confirmed");
                int totalPrice = resultSet.getInt("total_price");
                int userId = resultSet.getInt("user_id");
                order = new Order(userId,orderDate,destination,message,isDelivered,isConfirmed,totalPrice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
}
