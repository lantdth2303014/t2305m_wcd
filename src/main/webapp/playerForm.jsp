<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add/Edit Player</title>
</head>
<body>
<h1>${player != null ? 'Edit Player' : 'Add New Player'}</h1>
<form action="${player != null ? 'updatePlayer' : 'addPlayer'}" method="post">
    <input type="hidden" name="id" value="${player != null ? player.playerId : ''}">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${player != null ? player.name : ''}" required>
    </div>
    <div>
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" value="${player != null ? player.fullName : ''}" required>
    </div>
    <div>
        <label for="age">Age:</label>
        <input type="text" id="age" name="age" value="${player != null ? player.age : ''}" required>
    </div>
    <div>
        <label for="indexId">Index ID:</label>
        <input type="text" id="indexId" name="indexId" value="${player != null ? player.indexId : ''}" required>
    </div>
    <div>
        <button type="submit">${player != null ? 'Update' : 'Add'}</button>
    </div>
</form>
<br>
<a href="player">Back to Player List</a>
</body>
</html>
