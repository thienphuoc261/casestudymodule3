<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Management</title>
    <%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
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

        body {
            font-family: Arial, sans-serif;
            margin: 0;
        }

        h2 {
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        a {
            text-decoration: none;
            color: #337ab7;
        }

        .btn {
            display: inline-block;
            padding: 8px 16px;
            font-size: 14px;
            text-align: center;
            text-decoration: none;
            background-color: #337ab7;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #23527c;
        }
        .btn-edit {
            background-color: #2ecc71;
            color: #fff;
        }

        .btn-delete {
            background-color: #e74c3c;
            color: #fff;
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
            <a href="#">User Profile</a>
            <a href="/login">Log Out</a>
        </div>
    </div>
</div>
<div>
    <h2>Product Management</h2>
    <table>
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Manufacture Date</th>
            <th>Expiration Date</th>
            <th>Unit</th>
            <th>Import Date</th>
            <th>Actions</th>
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
                <td>
                    <a href="/viewproducts?action=edit&id=${product.id}" class="btn btn-edit">Edit</a>
                    <a href="/viewproducts?action=delete&id=${product.id}" class="btn btn-delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>--%>
</body>
</html>
