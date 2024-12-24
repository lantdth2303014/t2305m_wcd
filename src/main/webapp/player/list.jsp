<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.t2305m_wcd.entity.Player" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>Player List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
  <h1>Player List</h1>
  <a href="?action=create" class="btn btn-primary mb-3">Create a new Player</a>
  <table class="table table-bordered">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Full Name</th>
      <th scope="col">Age</th>
      <th scope="col">Index ID</th>
      <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
      List<Player> players = (List<Player>) request.getAttribute("players");
      if (players != null) {
        for(Player player : players) {
    %>
    <tr>
      <th scope="row"><%= player.getPlayerId() %></th>
      <td><%= player.getName() %></td>
      <td><%= player.getFullName() %></td>
      <td><%= player.getAge() %></td>
      <td><%= player.getIndexId() %></td>
      <td>
        <a href="player?action=edit&id=<%= player.getPlayerId() %>" class="btn btn-warning btn-sm">Edit</a>
        <a href="player?action=delete&id=<%= player.getPlayerId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
    <%
      }
    } else {
    %>
    <tr>
      <td colspan="6" class="text-center">No players found.</td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
</body>
</html>