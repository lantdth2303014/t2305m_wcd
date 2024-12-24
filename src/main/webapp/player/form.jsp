<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.t2305m_wcd.entity.Player" %>
<html>
<head>
    <title><%= request.getAttribute("player") != null ? "Edit Player" : "Create a new Player" %></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="player" method="post">
        <h1><%= request.getAttribute("player") != null ? "Edit Player" : "Create a new Player" %></h1>
        <%
            Player player = (Player) request.getAttribute("player");
            boolean isEditing = player != null;
        %>
        <% if (isEditing) { %>
        <input type="hidden" name="id" value="<%= player.getPlayerId() %>">
        <% } %>
        <input type="hidden" name="action" value="<%= isEditing ? "update" : "create" %>">

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" name="name" class="form-control" value="<%= isEditing ? player.getName() : "" %>" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Full Name</label>
            <input type="text" name="fullName" class="form-control" value="<%= isEditing ? player.getFullName() : "" %>" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Age</label>
            <input type="text" name="age" class="form-control" value="<%= isEditing ? player.getAge() : "" %>" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Index ID</label>
            <input type="number" name="indexId" class="form-control" value="<%= isEditing ? player.getIndexId() : "" %>" required>
        </div>
        <button type="submit" class="btn btn-primary"><%= isEditing ? "Update" : "Submit" %></button>
    </form>
</div>
</body>
</html>