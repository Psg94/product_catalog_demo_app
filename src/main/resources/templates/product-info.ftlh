<!DOCTYPE html>
<html>
<head>
    <title> Products catalog demo project </title>
</head>
<body>
<h2>Information about product:</h2>
<form action="/products/update" method="post" enctype="multipart/form-data">
    ID: <input type="number" name="id" value="${product.id}" readonly="true"/><br><br>
    Name: <input type="text" name="name" value="${product.name!""}"/><br><br>
    Description: <input type="text" name="description" value="${product.description!""}"/><br><br>
    Price: <input type="text" name="price" value="${product.price!""}"/><br><br>
    Category ID: <input type="number" name="categoryId" value="${product.categoryId!""}"/><br><br>
    Creation date: <input type="text" name="creationDate" value="${product.creationDate!""}" readonly="true"/><br><br>
    Status: <input type="text" name="status" value="${product.status!""}"/><br><br>
    <img src="${product.getImageDisplay()!""}" style="width: 250px;height: 180px;"/><br><br>
    <input type="file" name="productImageFile"/><br><br>

    <input type="submit" value="Update" style="width: 80px;"/>
</form>
<br>
<form action="/products/delete/${product.id}" method="post">
    <input type="submit" value="Delete" style="width: 80px;"/>
</form>
</body>
</html>