
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Players</title>
</head>
<body>
<h1>All Players</h1>
<a href="addPlayer">Add New Player</a>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Index Name</th>
        <th>Value</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="player" items="${player}">
        <tr>
            <td>${player.name}</td>
            <td>${player.age}</td>
            <td>${player.index}</td>
            <td>
                <a href="playerForm?id=${player.playerId}">Edit</a>
                <a href="deletePlayer?id=${player.playerId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="/">Back to Home</a>
</body>
</html>
