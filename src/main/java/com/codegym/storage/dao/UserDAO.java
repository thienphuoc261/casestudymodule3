package com.codegym.storage.dao;

import com.codegym.storage.connection.JDBCConnection;
import com.codegym.storage.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/storage?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private static final String INSERT_USERS_SQL = "insert into user (email,user_name,password,role_name) VALUES (?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select * from user where id =?";
    private static final String SELECT_ALL_USERS = "select * from user where is_delete = false;";
    private static final String DELETE_USERS_SQL = "update user set is_delete = 1 where id = ?;";
    private static final String UPDATE_USERS_SQL = "update user set email = ?, user_name = ?, password = ?, role_name = ? where id = ?;";
    private static final String LOGIN_SQL = "select * from user where user_name = ? and password = ?;";
    private static final String CHECK_ROLE_MANAGER = "select * from user where role_name = 'manager';";
    private static final String SELECT_ID_BY_USERNAME = "select id from user where user_name = ?;";
    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                String email = rs.getString("email");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                String roleName = rs.getString("role_name");
                user = User.builder()
                        .id(ID)
                        .email(email)
                        .userName(userName)
                        .password(password)
                        .role(roleName)
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                String email = rs.getString("email");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                String roleName = rs.getString("role_name");
                int isDelete = rs.getInt("is_delete");
                User user = User.builder()
                        .id(ID)
                        .email(email)
                        .userName(userName)
                        .password(password)
                        .role(roleName)
                        .build();
                users.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
            preparedStatement.setInt(1, id);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setInt(5,user.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public User login(String userName, String password) throws SQLException {
        User user = null;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String userName1 = resultSet.getString("user_name");
                String password1 = resultSet.getString("password");
                String roleName = resultSet.getString("role_name");
                user = User.builder()
                        .id(id)
                        .email(email)
                        .userName(userName1)
                        .password(password1)
                        .role(roleName)
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean login(User user) throws SQLException {
        boolean success = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_SQL)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            success = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }


    public List<User> selectAllManagers() throws SQLException {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ROLE_MANAGER);
            ResultSet resultSet = preparedStatement.executeQuery();
            String email = resultSet.getString("email");
            String userName = resultSet.getString("user_name");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role_name");
            User user = User.builder()
                    .email(email)
                    .userName(userName)
                    .password(password)
                    .role(role)
                    .build();
            userList.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
    
    public int selectIdFromUser(String userName) throws SQLException {
        int id = 0;
        try {
            Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_BY_USERNAME);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                preparedStatement.close();
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
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
