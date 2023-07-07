<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Product</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.0/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 20px;
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
        .btn {
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h3>Order Details:</h3>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Quantity</th>
            <th>Sub Total Price</th>
            <th></th>
        </tr>
        <c:forEach var="orderDetail" items="${orderDetailsList}">
            <tr>
                <td>${orderDetail.productId}</td>
                <td>${orderDetail.quantity}</td>
                <td>${orderDetail.unitPrice}</td>
                <td>${orderDetail.subTotalPrice}</td>
                <td>
                    <a href="/orderdetail?action=delete&id=${orderDetail.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h3>Product List:</h3>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Manufacture Date</th>
            <th>Expiration Date</th>
            <th>Import Date</th>
        </tr>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.id}</td>
                <td>${product.productName}</td>
                <td>${product.quantity}</td>
                <td>${product.unitPriceOfProduct}</td>
                <td>${product.manufactureDate}</td>
                <td>${product.expirationDate}</td>
                <td>${product.importDate}</td>
            </tr>
        </c:forEach>
    </table>

    <h3>Add Order Detail:</h3>
    <form action="/orderproduct" method="post">
        <div class="form-group">
            <label for="orderDate">Order Date:</label>
            <input type="datetime-local" name="orderDate" id="orderDate" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="destination">Destination:</label>
            <input type="text" name="destination" id="destination" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="message">Message:</label>
            <input type="text" name="message" id="message" class="form-control" required>
        </div>

            <input type="hidden" name="orderId" id="orderId" class="form-control" value="${orderId}" required>

        <div class="form-group">
            <label for="productId">Product ID:</label>
            <input type="text" name="productId" id="productId" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" name="quantity" id="quantity" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">Add Order Detail</button>
    </form>
</div>
</body>
</html>
