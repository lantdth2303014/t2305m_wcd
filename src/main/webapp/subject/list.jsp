<%@ page import="com.example.t2305m_wcd.entity.Subject" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: quanghoatrinh
  Date: 03/12/2024
  Time: 08:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>List subject</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
  <h1>Subject List</h1>
  <a href="?action=create">Create a new subject</a>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Code</th>
      <th scope="col">Hour</th>
    </tr>
    </thead>
    <tbody>
    <% for(Subject s : (List<Subject>)request.getAttribute("subjects")){ %>
    <tr>
      <th scope="row"><%= s.getId() %></th>
      <td><%= s.getName() %></td>
      <td><%= s.getCode() %></td>
      <td><%= s.getHour() %></td>
      <td>
        <a href="?action=edit&id=<%= s.getId() %>" class="btn btn-primary btn-sm">Edit</a>
        <a href="?action=delete&id=<%= s.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
    <% } %>

    </tbody>
  </table>
</div>
</body>
</html>