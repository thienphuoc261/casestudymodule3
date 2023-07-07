package com.codegym.storage.controller;

import com.codegym.storage.dao.ProductDAO;
import com.codegym.storage.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ExportProductServlet", value = "/exportproduct")
public class ExportProductServlet extends HttpServlet {
    private static List<Product> productList;
    private static ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productList = productDAO.selectAllProducts();
        request.setAttribute("productList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/exportproduct.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String exportDate = request.getParameter("exportDate");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            productDAO.updateProductQuantity(productId, quantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Product> productList = productDAO.selectAllProducts();
        request.setAttribute("productList", productList);
        response.sendRedirect("/exportproduct");
    }
}
