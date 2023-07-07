package com.codegym.storage.controller;

import com.codegym.storage.dao.OrderDAO;
import com.codegym.storage.dao.UserDAO;
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
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static List<User> userList;
    private static UserDAO userDAO = new UserDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = userDAO.login(username,password);
            if (user != null) {
                HttpSession session = request.getSession();
                OrderDAO orderDAO = new OrderDAO();
                session.setAttribute("user", user);
                int userid = user.getId();
                Order order = orderDAO.getOrderByUserId(userid);
                if(order != null) {
                    session.setAttribute("order",order);
                } else {
                    order = new Order(userid);
                    session.setAttribute("order",order);
                }
                if ("manager".equals(user.getRole())) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
                    requestDispatcher.forward(request, response);
                } else if ("customer".equals(user.getRole())) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customerhome.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else {
                response.sendRedirect("/login");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);
    }
}