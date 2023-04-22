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
<h1>Product categories catalog</h1> <hr>
<h2>Search filters: </h2>
<form action="/categories" method="get">
    Name: <input type="text" name="name"><br><br>
    Description: <input type="text" name="description"><br><br>
    <input type="submit" value="Search"/>
</form>
<h2>Product categories list: </h2>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
    </tr>
    </thead>
    <tbody>
    <#list categories as category>
        <tr>
            <th scope="row">${category.id}</th>
            <td>${category.name!""}</td>
            <td>${category.description!""}</td>
            <td><a href="/categories/${category.id}">Edit</a></td>
        </tr>
    </#list>
    </tbody>
</table>
<hr>
<h2>Add new category: </h2>
<form action="/categories/create" method="post">
    Name: <input type="text" name="name"/><br><br>
    Description: <input type="text" name="description"/><br><br>
    <input type="submit" value="Add"/>
</form>
<hr>
<h3><a href="/products">Go to all products...</a></h3>
</body>
</html>