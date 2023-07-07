<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Customer Home</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <style>
    body {
      background-color: #f8f9fa;
      font-family: Arial, sans-serif;
      background-image: url(https://img.freepik.com/free-vector/warehouse-interior-logistics-cargo-delivery_107791-1777.jpg?w=900&t=st=1686287564~exp=1686288164~hmac=8b47d7281d6bb559e421729d75bb6e8d30fabe154c2da8bf8cb93132c82aa515);
      background-repeat: no-repeat;
      background-size: cover;
    }

    .navbar {
      background-color: #fff;
    }

    .navbar-brand {
      font-size: 1.5rem;
      font-weight: bold;
      color: #333;
    }

    .navbar-nav .nav-item .nav-link {
      color: #333;
      font-weight: bold;
    }

    .dropdown-menu {
      background-color: #fff;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    .dropdown-item {
      color: #333;
      font-weight: bold;
    }

    .container {
      margin-top: 2rem;
    }

    h2 {
      font-size: 1.8rem;
      color: #333;
      margin-bottom: 1.5rem;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><i class="fa fa-home"></i> Customer Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="/orderproduct"><i class="fa fa-cart-plus"></i> Order Products</a>
      </li>
    </ul>
    <ul class="navbar-nav">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false">
          <i class="fa fa-user"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="/login.jsp"><i class="fa fa-sign-out"></i> Log Out</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
