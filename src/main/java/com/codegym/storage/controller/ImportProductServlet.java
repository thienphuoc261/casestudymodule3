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

@WebServlet(name = "Import", value = "/importproduct")
public class ImportProductServlet extends HttpServlet {
    private static List<Product> productList;
    private static ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        productList = productDAO.selectAllProducts();
        request.setAttribute("productList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/importproduct.jsp");
        requestDispatcher.forward(request, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int unitPriceOfProduct = Integer.parseInt(request.getParameter("unitPriceOfProduct"));
        String manufactureDate = request.getParameter("manufactureDate");
        String expirationDate = request.getParameter("expirationDate");
        String unit = request.getParameter("unit");
        String importDate = request.getParameter("importDate");

        Product newProduct = Product.builder()
                .productName(productName)
                .quantity(quantity)
                .unitPriceOfProduct(unitPriceOfProduct)
                .manufactureDate(manufactureDate)
                .expirationDate(expirationDate)
                .unit(unit)
                .importDate(importDate)
                .build();
        try {
            productDAO.insertProducts(newProduct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        productList = productDAO.selectAllProducts();
        request.setAttribute("productList", productList);
        response.sendRedirect("/importproduct");
    }
}

