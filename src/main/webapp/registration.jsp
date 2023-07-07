<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Registration Form</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <style>
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .container {
      width: 400px;
      padding: 20px;
      background-color: #ffffff;
      border: 1px solid #dee2e6;
      border-radius: 4px;
      box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
    }

    .container h2 {
      text-align: center;
      margin-bottom: 20px;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Registration Form</h2>
  <form action="/registration" method="post">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="form-group">
      <label for="username">Username:</label>
      <input type="text" class="form-control" id="username" name="username" required>
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <div class="form-group">
      <label for="phonenumber">Phone Number:</label>
      <input type="text" class="form-control" id="phonenumber" name="phonenumber" required>
    </div>
    <div class="form-group">
      <label for="role">Role:</label>
      <select class="form-control" id="role" name="role" required>
        <option value="manager">Manager</option>
        <option value="customer">Customer</option>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Register</button>
  </form>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

