<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manager Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
        background-image: url(https://img.freepik.com/free-vector/warehouse-interior-with-cardboard-boxes_107791-3324.jpg?w=1060&t=st=1686207053~exp=1686207653~hmac=45fe49313169bd25f2d3d65ffee983a4affc1b3f66055d947e84fb4ba60b22dd);
        background-repeat: no-repeat;
        background-size: cover;
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
        display: block;
        padding: 12px 16px;
        text-decoration: none;
        text-align: left;
    }

    .dropdown-content a:hover {
        background-color: #ddd;
    }

    .dropdown:hover .dropdown-content {
        display: block;
    }
</style>
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
</body>
</html>
