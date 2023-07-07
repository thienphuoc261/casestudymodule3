<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Import Product</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
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

        .container {
            max-width: 960px;
            margin: 0 auto;
            padding: 20px;
        }

        h2 {
            margin-top: 0;
        }

        form {
            display: flex;
            flex-wrap: wrap;
            margin-bottom: 20px;
        }

        .form-group {
            margin-right: 10px;
            margin-bottom: 10px;
        }

        label {
            display: inline-block;
            width: 120px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"] {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        .custom-button {
            padding: 10px 20px;
            background-color: #337ab7;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        .custom-button:hover {
            background-color: #286090;
        }

        hr {
            margin: 40px 0;
            border: none;
            border-top: 1px solid #ccc;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            border-bottom: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        .form-inline {
            display: flex;
            flex-wrap: wrap;
            margin-bottom: 20px;
        }

        .form-group {
            margin-right: 10px;
            margin-bottom: 10px;
        }

        label {
            display: inline-block;
            width: 120px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"] {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        .custom-button {
            padding: 10px 20px;
            background-color: #337ab7;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            position: -ms-device-fixed;
        }

        .custom-button:hover {
            background-color: #286090;
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
<div class="container">
    <h2>Import Product</h2>
    <form action="importproduct" method="post" class="form-inline">
        <div class="form-group mr-2">
            <label for="productName">Product Name:</label>
            <input type="text" name="productName" id="productName" class="form-control" required>
        </div>
        <div class="form-group mr-2">
            <label for="quantity">Quantity:</label>
            <input type="number" name="quantity" id="quantity" class="form-control" required>
        </div>
        <div class="form-group mr-2">
            <label for="unitPriceOfProduct">Unit Price:</label>
            <input type="number" name="unitPriceOfProduct" id="unitPriceOfProduct" class="form-control" required>
        </div>
        <div class="form-group mr-2">
            <label for="manufactureDate">Manufacture Date:</label>
            <input type="date" name="manufactureDate" id="manufactureDate" class="form-control" required>
        </div>
        <div class="form-group mr-2">
            <label for="expirationDate">Expiration Date:</label>
            <input type="date" name="expirationDate" id="expirationDate" class="form-control" required>
        </div>
        <div class="form-group mr-2">
            <label for="unit">Unit:</label>
            <input type="text" name="unit" id="unit" class="form-control" required>
        </div>
        <div class="form-group mr-2">
            <label for="importDate">Import Date:</label>
            <input type="date" name="importDate" id="importDate" class="form-control" required>
        </div>
        <button type="submit" class="custom-button">Import Product</button>
    </form>
    <hr>
    <h2>Product List</h2>
    <table>
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Manufacture Date</th>
            <th>Expiration Date</th>
            <th>Unit</th>
            <th>Import Date</th>
        </tr>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.productName}</td>
                <td>${product.quantity}</td>
                <td>${product.unitPriceOfProduct}</td>
                <td>${product.manufactureDate}</td>
                <td>${product.expirationDate}</td>
                <td>${product.unit}</td>
                <td>${product.importDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
