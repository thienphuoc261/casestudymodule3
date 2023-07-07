<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit Product</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h2>Edit Product</h2>
  <form action="/viewproducts?action=edit" method="post">
    <div class="form-group">
      <label for="productName">Product Name:</label>
      <input type="hidden" name="id" value="${product.id}">
      <input type="text" name="productName" id="productName" class="form-control" value="${product.productName}" required>
    </div>

    <div class="form-group">
      <label for="quantity">Quantity:</label>
      <input type="number" name="quantity" id="quantity" class="form-control" value="${product.quantity}" required>
    </div>

    <div class="form-group">
      <label for="unitPriceOfProduct">Unit Price:</label>
      <input type="number" name="unitPriceOfProduct" id="unitPriceOfProduct" class="form-control" value="${product.unitPriceOfProduct}" required>
    </div>

    <div class="form-group">
      <label for="manufactureDate">Manufacture Date:</label>
      <input type="date" name="manufactureDate" id="manufactureDate" class="form-control" value="${product.manufactureDate}" required>
    </div>

    <div class="form-group">
      <label for="expirationDate">Expiration Date:</label>
      <input type="date" name="expirationDate" id="expirationDate" class="form-control" value="${product.expirationDate}" required>
    </div>

    <div class="form-group">
      <label for="unit">Unit:</label>
      <input type="text" name="unit" id="unit" class="form-control" value="${product.unit}" required>
    </div>

    <div class="form-group">
      <label for="importDate">Import Date:</label>
      <input type="date" name="importDate" id="importDate" class="form-control" value="${product.importDate}" required>
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
  </form>
</div>
</body>
</html>
