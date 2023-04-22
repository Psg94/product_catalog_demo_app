<!DOCTYPE html>
<html>
<head>
    <title> Products catalog demo project </title>
</head>
<body>
<h2>Information about product category:</h2>
<form action="/categories/update" method="post">
    ID: <input type="number" name="id" value="${category.id}" readonly="true"/><br><br>
    Name: <input type="text" name="name" value="${category.name!""}"/><br><br>
    Description: <input type="text" name="description" value="${category.description!""}"/><br><br>
    <input type="submit" value="Update" style="width: 80px;"/>
</form>
<br>
<form action="/categories/delete/${category.id}" method="post">
    <input type="submit" value="Delete" style="width: 80px;"/>
</form>
</body>
</html>