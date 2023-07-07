<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit User</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.0/css/bootstrap.min.css">
  <style>
    body {
      background-color: #f8f9fa;
      padding-top: 50px;
    }

    .container {
      max-width: 500px;
      margin: 0 auto;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
    }

    .form-group {
      margin-bottom: 20px;
    }

    label {
      font-weight: bold;
    }

    .btn-primary {
      background-color: #007bff;
      border-color: #007bff;
    }

    .btn-primary:hover {
      background-color: #0069d9;
      border-color: #0062cc;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Edit User</h2>
  <form action="/userservice?action=edit" method="post">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="hidden" name="id" value="${user.id}">
      <input type="email" name="email" id="email" class="form-control" value="${user.email}" required>
    </div>

    <div class="form-group">
      <label for="username">Username:</label>
      <input type="text" name="username" id="username" class="form-control" value="${user.userName}" required>
    </div>

    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" name="password" id="password" class="form-control" value="${user.password}" required>
    </div>

    <div class="form-group">
      <label for="role">Role:</label>
      <select name="role" id="role" class="form-control" required>
        <option value="manager" ${user.role == 'manager' ? 'selected' : ''}>Manager</option>
        <option value="customer" ${user.role == 'customer' ? 'selected' : ''}>Customer</option>
      </select>
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
  </form>
</div>
</body>
</html>
