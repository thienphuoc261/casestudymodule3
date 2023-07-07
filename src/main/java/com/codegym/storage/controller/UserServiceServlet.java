package com.codegym.storage.controller;

import com.codegym.storage.dao.UserDAO;
import com.codegym.storage.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServiceServlet", value = "/userservice")
public class UserServiceServlet extends HttpServlet {
    private static List<User> userList;
    private static UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userList = userDAO.selectAllUsers();
        request.setAttribute("userList", userList);
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "edit":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteUser(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("userservice.jsp");
                dispatcher1.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                try {
                    updateUser(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        int id = Integer.parseInt(request.getParameter("id"));

        User user = User.builder()
                .id(id)
                .email(email)
                .userName(userName)
                .password(password)
                .role(role)
                .build();

        userDAO.updateUser(user);
        response.sendRedirect("/userservice");
    }

    private void deleteUser (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        userList = userDAO.selectAllUsers();
        response.sendRedirect("/userservice");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edituser.jsp");
        request.setAttribute("user", user);
        dispatcher.forward(request, response);
    }
}
