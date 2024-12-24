<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Player</title>
</head>
<body>
<h1>Edit Player</h1>
<form action="player" method="POST">
    <input type="hidden" name="playerId" value="${player.playerId}">
    <label for="name">Name: </label>
    <input type="text" id="name" name="name" value="${player.name}" required>
    <br>
    <label for="fullName">Full Name: </label>
    <input type="text" id="fullName" name="fullName" value="${player.fullName}" required>
    <br>
    <label for="age">Age: </label>
    <input type="text" id="age" name="age" value="${player.age}" required>
    <br>
    <input type="submit" value="Update">
</form>
<br>
<a href="player">Back</a>
</body>
</html>
