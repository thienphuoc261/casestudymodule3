package com.codegym.storage.dao;

import com.codegym.storage.connection.JDBCConnection;
import com.codegym.storage.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String INSERT_PRODUCTS_SQL = "insert into product (product_name,quantity,unit_price,manufacture_date,expiration_date,unit,import_date) values(?,?,?,?,?,?,?);";
    private static final String UPDATE_PRODUCT_SQL = "update product set product_name = ?" +
            ",quantity = ?," +
            "unit_price = ?," +
            "manufacture_date = ?," +
            "expiration_date = ?," + "unit = ?," +
            "import_date = ? " +
            "where id = ?;";
    private static final String DELETE_PRODUCT_SQL = "update product set is_delete = 1 where id = ?;";
    private static final String SELECT_ALL_PRODUCTS = "select * from product where is_delete = false;";
    private static final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?;";
    private static final String UPDATE_PRODUCT_QUANTITY = "update product set quantity = quantity - ? where id = ?;";

    public ProductDAO() {
    }

    public void insertProducts (Product product) throws SQLException {
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2,product.getQuantity());
            preparedStatement.setInt(3,product.getUnitPriceOfProduct());
            preparedStatement.setString(4,product.getManufactureDate());
            preparedStatement.setString(5,product.getExpirationDate());
            preparedStatement.setString(6,product.getUnit());
            preparedStatement.setString(7,product.getImportDate());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Product selectProduct (int id) throws SQLException {
        Product product = null;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idProduct = resultSet.getInt("id");
                String productName = resultSet.getString("product_name");
                int quantity = resultSet.getInt("quantity");
                int unitPrice = resultSet.getInt("unit_price");
                String manufactureDate = resultSet.getString("manufacture_date");
                String expirationDate = resultSet.getString("expiration_date");
                String unit = resultSet.getString("unit");
                String importDate = resultSet.getString("import_date");
                product = Product.builder().id(idProduct)
                        .productName(productName)
                        .unitPriceOfProduct(unitPrice)
                        .manufactureDate(manufactureDate)
                        .expirationDate(expirationDate)
                        .unit(unit)
                        .quantity(quantity)
                        .importDate(importDate)
                        .build();
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> selectAllProducts(){
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("product_name");
                int quantity = resultSet.getInt("quantity");
                int unitPrice = resultSet.getInt("unit_price");
                String manufactureDate = resultSet.getString("manufacture_date");
                String expirationDate = resultSet.getString("expiration_date");
                String unit = resultSet.getString("unit");
                String importDate = resultSet.getString("import_date");
                Product product = Product.builder()
                        .productName(productName)
                        .quantity(quantity)
                        .unitPriceOfProduct(unitPrice)
                        .manufactureDate(manufactureDate)
                        .expirationDate(expirationDate)
                        .unit(unit)
                        .importDate(importDate)
                        .id(id)
                        .build();
                productList.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    public boolean deleteProduct (int id) throws SQLException {
        boolean rowUpdated = false;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);
            preparedStatement.setInt(1,id);
            rowUpdated = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public boolean updateProduct (Product product) throws SQLException {
        boolean rowUpdated = false;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2,product.getQuantity());
            preparedStatement.setInt(3,product.getUnitPriceOfProduct());
            preparedStatement.setString(4,product.getManufactureDate());
            preparedStatement.setString(5, product.getExpirationDate());
            preparedStatement.setString(6, product.getUnit());
            preparedStatement.setString(7,product.getImportDate());
            preparedStatement.setInt(8,product.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public void updateProductQuantity (int id, int quantity) throws SQLException {
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_QUANTITY);
            preparedStatement.setInt(2,id);
            preparedStatement.setInt(1,quantity);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
