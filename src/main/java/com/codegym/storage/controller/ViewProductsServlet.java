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

@WebServlet(name = "ViewProductsServlet", value = "/viewproducts")
public class ViewProductsServlet extends HttpServlet {
    private static ProductDAO productDAO = new ProductDAO();
    private static List<Product> productList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productList = productDAO.selectAllProducts();
        request.setAttribute("productList", productList);
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
                    deleteProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("viewproducts.jsp");
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
                    updateProduct(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteProduct(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String productName = request.getParameter("productName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int unitPriceOfProduct = Integer.parseInt(request.getParameter("unitPriceOfProduct"));
        String manufactureDate = request.getParameter("manufactureDate");
        String expirationDate = request.getParameter("expirationDate");
        String unit = request.getParameter("unit");
        String importDate = request.getParameter("importDate");
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = Product.builder()
                .id(id)
                .productName(productName)
                .quantity(quantity)
                .unitPriceOfProduct(unitPriceOfProduct)
                .manufactureDate(manufactureDate)
                .expirationDate(expirationDate)
                .unit(unit)
                .importDate(importDate)
                .build();
        productDAO.updateProduct(product);
        response.sendRedirect("/viewproducts");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        productList = productDAO.selectAllProducts();
        response.sendRedirect("/viewproducts");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.selectProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("product", product);
        dispatcher.forward(request, response);
    }
}
