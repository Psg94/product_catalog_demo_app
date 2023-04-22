<!DOCTYPE html>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid;
        }
    </style>
    <title> Products catalog demo project </title>
</head>
<body>
<h1>Product catalog</h1> <hr>
<h2>Search filters: </h2>
<form action="/products" method="get">
    Name: <input type="text" name="name"><br><br>
    Description: <input type="text" name="description"><br><br>
    Price From: <input type="text" name="priceFrom"><br><br>
    Price To: <input type="text" name="priceTo"><br><br>
    <input type="submit" value="Search"/>
</form>
<hr>
<h2>Products list: </h2>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
        <th scope="col">Price</th>
        <th scope="col">Category ID</th>
        <th scope="col">Creation Date</th>
        <th scope="col">Status</th>
        <th scope="col">Image</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
        <tr>
            <th scope="row">${product.id}</th>
            <td>${product.name!""}</td>
            <td>${product.description!""}</td>
            <td>${product.price!""}</td>
            <td>${product.categoryId!""}</td>
            <td>${product.creationDate!""}</td>
            <td>${product.status!""}</td>
            <td><img src="${product.imageDisplay!""}" style="width: 50px;height: 30px;"/></td>
            <td><a href="/products/${product.id}">Edit</a></td>
        </tr>
    </#list>
    </tbody>
</table>
<hr>
<h2>Add new product: </h2>
<form action="/products/create" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="name"/><br><br>
    Description: <input type="text" name="description"/><br><br>
    Price: <input type="text" name="price"/><br><br>
    Category ID: <input type="number" name="categoryId"/><br><br>
    Status: <input type="text" name="status"/><br><br>
    <input type="file" name="productImageFile"/><br><br>
    <input type="submit" value="Add"/>
</form>
<hr>
</body>
</html>