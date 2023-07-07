<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Export Product</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        .container {
            width: 800px;
            padding: 20px;
            background-color: #f8f9fa;
            border: 1px solid #dee2e6;
            border-radius: 4px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
        }

        .container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .navbar {
            overflow: hidden;
            background-color: #3399FF;
            width: 100%;
            height: 50px;
        }

        .navbar a {
            float: left;
            font-size: 16px;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .dropdown {
            float: left;
            overflow: hidden;
        }

        .dropdown .drop-btn {
            font-size: 16px;
            border: none;
            outline: none;
            color: white;
            padding: 14px 16px;
            background-color: inherit;
            font-family: inherit;
            margin: 0;
        }

        .navbar a:hover, .dropdown:hover .drop-btn {
            background-color: red;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        .dropdown-content a {
            float: none;
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {
            background-color: #ddd;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .export-form {
            width: 800px;
            padding: 20px;
            background-color: #f8f9fa;
            border: 1px solid #dee2e6;
            border-radius: 4px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
            text-align: center;
        }

        .export-form h2 {
            margin-bottom: 20px;
        }

        .export-form input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        .export-form button {
            padding: 10px 20px;
            background-color: #3399FF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .product-list {
            width: 800px;
            text-align: center;
        }

        .product-list table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .product-list th,
        .product-list td {
            padding: 8px;
            border: 1px solid #dee2e6;
        }

        .product-list th {
            background-color: #f8f9fa;
            font-weight: bold;
        }
        .export-form {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f8f9fa;
            border: 1px solid #dee2e6;
            border-radius: 4px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
        }

        .export-form h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .export-form label {
            display: block;
            margin-bottom: 8px;
        }

        .export-form input[type="text"],
        .export-form input[type="number"],
        .export-form input[type="date"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }

        .export-form button[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #3399FF;
            border: none;
            color: white;
            border-radius: 4px;
            font-size: 14px;
            cursor: pointer;
        }

        .export-form button[type="submit"]:hover {
            background-color: #1779D7;
        }
    </style>
</head>
<body>
<div class="navbar">
    <a href="home">Home</a>
    <a href="registration">Registration</a>
    <a href="userservice">User Service</a>
    <div class="dropdown">
        <button class="drop-btn">Product Services
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/importproduct">Import Product</a>
            <a href="/exportproduct">Export Product</a>
            <a href="/viewproducts">View Products</a>
            <a href="#">Export Report</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="drop-btn">Customer Services
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="#">View Customers</a>
            <a href="#">Order Status</a>
        </div>
    </div>
    <div class="dropdown" style="float: right">
        <button class="drop-btn">Welcome, ${user.userName}
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="/login">Log Out</a>
        </div>
    </div>
</div>
<div class="form">
    <div class="export-form">
        <h2>Export Product</h2>
        <form action="/exportproduct" method="post">
            <div>
                <div>
                    <label for="productId">Product ID:</label>
                    <input type="text" id="productId" name="productId" required>
                </div>
                <div>
                    <label for="quantity">Quantity:</label>
                    <input type="number" id="quantity" name="quantity" required>
                </div>
                <div>
                    <label for="exportDate">Export Date:</label>
                    <input type="date" id="exportDate" name="exportDate" required>
                </div>
            </div>
            <div class="text-center">
                <button type="submit">Export</button>
            </div>
        </form>
    </div>
    <div class="product-list">
        <h2>Product List</h2>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Unit Price</th>
                <th>Manufacture Date</th>
                <th>Expiration Date</th>
                <th>Unit</th>
                <th>Import Date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${requestScope.productList}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.quantity}</td>
                    <td>${product.unitPriceOfProduct}</td>
                    <td>${product.manufactureDate}</td>
                    <td>${product.expirationDate}</td>
                    <td>${product.unit}</td>
                    <td>${product.importDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
