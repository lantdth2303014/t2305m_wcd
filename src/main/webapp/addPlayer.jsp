<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new player</title>
</head>
<body>
<h1>Add new player</h1>
<form action="player" method="POST">
    <label for="name">Name: </label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="fullName">Full Name: </label>
    <input type="text" id="fullName" name="fullName" required>
    <br>
    <label for="age">Age: </label>
    <input type="text" id="age" name="age" required>
    <br>
    <input type="submit" value="add player">
</form>
<br>
<a href="player">Back</a>
</body>
</html>
