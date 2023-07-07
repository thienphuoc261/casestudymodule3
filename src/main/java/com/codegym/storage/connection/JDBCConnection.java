package com.codegym.storage.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONN_URL = "jdbc:mysql://localhost:3306/storage";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);
            return connection;
        } catch (Exception e) {
            System.out.println("Could not find database!");
            e.printStackTrace();
        }
        return null;
    }
}
