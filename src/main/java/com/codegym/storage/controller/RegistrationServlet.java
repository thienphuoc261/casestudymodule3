package com.codegym.storage.controller;

import com.codegym.storage.dao.CustomerDAO;
import com.codegym.storage.dao.OrderDAO;
import com.codegym.storage.dao.UserDAO;
import com.codegym.storage.model.Customer;
import com.codegym.storage.model.Order;
import com.codegym.storage.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String role = request.getParameter("role");
            String name = request.getParameter("name");
            String phoneNumber = request.getParameter("phonenumber");
            UserDAO userDAO = new UserDAO();
            User user = User.builder()
                    .userName(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .build();
            userDAO.insertUser(user);
            int id = userDAO.selectIdFromUser(username);
            if (user.getRole().equals("customer")) {
                CustomerDAO customerDAO = new CustomerDAO();
                OrderDAO orderDAO = new OrderDAO();
                Customer customer = new Customer(id,name,phoneNumber);
                customerDAO.insertCustomer(customer);
                Order order = new Order(id);
                orderDAO.insertOrder(order);
                HttpSession session = request.getSession();
                session.setAttribute("order",order);
            }
            response.sendRedirect("home");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
