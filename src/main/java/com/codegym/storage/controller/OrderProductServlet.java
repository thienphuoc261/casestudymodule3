package com.codegym.storage.controller;

import com.codegym.storage.dao.OrderDAO;
import com.codegym.storage.dao.OrderDetailsDAO;
import com.codegym.storage.dao.ProductDAO;
import com.codegym.storage.model.Order;
import com.codegym.storage.model.OrderDetail;
import com.codegym.storage.model.Product;
import com.codegym.storage.model.User;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "OrderProductServlet", value = "/orderproduct")
public class OrderProductServlet extends HttpServlet {
    private static OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
    private static ProductDAO productDAO = new ProductDAO();
    private static OrderDAO orderDao = new OrderDAO();
    private static List<OrderDetail> orderDetailList;
    private static List<Product> productList;
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Order order = (Order) request.getSession().getAttribute("order");
        int id = order.getId();
        orderDetailList = orderDetailsDAO.selectAllOrderDetailsByUserId(user.getId());
        productList = productDAO.selectAllProducts();
        request.setAttribute("orderDetailList", orderDetailList);
        request.setAttribute("productList", productList);
        request.setAttribute("orderId", id);
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "delete":
                try {
                    deleteOrderDetail(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/orderproduct.jsp");
                requestDispatcher.forward(request, response);
                break;
        }

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderDate = request.getParameter("orderDate");
        String destination = request.getParameter("destination");
        String message = request.getParameter("message");
//        Order order = (Order) request.getSession().getAttribute("order");
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        orderDao.updateOrder(orderDate,destination,message,orderId);
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = productDAO.selectProduct(productId);
        int unitPrice = product.getUnitPriceOfProduct();
        int subTotalPrice = quantity * unitPrice;
        OrderDetail orderDetail = new OrderDetail(productId,orderId,unitPrice,quantity,subTotalPrice);
        orderDetailsDAO.inserOrderDetail(orderDetail);
        response.sendRedirect("/orderproduct");
    }

    private void deleteOrderDetail (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        orderDetailsDAO.deleteOrderDetail(id);
        response.sendRedirect("/orderproduct");
    }
}
