package com.codegym.storage.dao;

import com.codegym.storage.connection.JDBCConnection;
import com.codegym.storage.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDAO {
    private static final String INSERT_ORDER_DETAIL = "insert into order_detail (product_id,order_id,unit_price,quantity,sub_total_price) values (?,?,?,?,?);";
    private static final String SELECT_ALL_ORDER_DETAIL = "select * from order_detail where is_deleted = false;";
    private static final String SELECT_ALL_ORDER_DETAIL_BY_ORDERID = "select * from order_detail where is_deleted = false and order_id = ?;";
    private static final String DELETE_ORDER_DETAIL_BY_ID = "update order_detail set is_deleted = 1 where id = ?;";
    public List<OrderDetail> selectAllOrderDetails() throws SQLException{
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER_DETAIL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int productId = resultSet.getInt("product_id");
                int orderId = resultSet.getInt("order_id");
                int unitPrice = resultSet.getInt("unit_price");
                int quantity = resultSet.getInt("quanity");
                int subTotalPrice = resultSet.getInt("sub_total_price");
                OrderDetail orderDetail = new OrderDetail(productId,orderId,unitPrice,quantity,subTotalPrice);
                orderDetailList.add(orderDetail);
                preparedStatement.close();
                connection.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return orderDetailList;
    }

    public void inserOrderDetail(OrderDetail orderDetail) throws SQLException {
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_DETAIL);
            preparedStatement.setInt(1,orderDetail.getProductId());
            preparedStatement.setInt(2,orderDetail.getOrderId());
            preparedStatement.setInt(3,orderDetail.getUnitPrice());
            preparedStatement.setInt(4,orderDetail.getQuantity());
            preparedStatement.setInt(5,orderDetail.getSubTotalPrice());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OrderDetail> selectAllOrderDetailsByUserId(int id) throws SQLException{
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER_DETAIL_BY_ORDERID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int orderId = resultSet.getInt("order_id");
                int unitPrice = resultSet.getInt("unit_price");
                int quantity = resultSet.getInt("quanity");
                int subTotalPrice = resultSet.getInt("sub_total_price");
                OrderDetail orderDetail = new OrderDetail(productId,orderId,unitPrice,quantity,subTotalPrice);
                orderDetailList.add(orderDetail);
                preparedStatement.close();
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetailList;
    }

    public boolean deleteOrderDetail (int id) throws SQLException{
        boolean rowUpdate = false;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_DETAIL_BY_ID);
            preparedStatement.setInt(1,id);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
}
