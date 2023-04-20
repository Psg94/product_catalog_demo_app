<!DOCTYPE html>
<html>
<head>
    <title> Products catalog demo project </title>
</head>
<body>
<h1>Product categories catalog</h1> <hr>
<form action="/categories" method="get">
    Search by category name: <input type="text" name="name"><br><br>
    Search by category description: <input type="text" name="description"><br><br>
    <input type="submit" value="Search"/>
</form>
<hr>
<h2>Product categories list: </h2>
<#list categories as category>
    <div>
        <p><b>${category.name}:</b> ${category.description} | <a href="/categories/${category.id}">Edit</a></p>
    </div>
<#else>
    <div>
        <h3>There are no categories in catalog</h3>
    </div>
</#list>
<hr>
<h2>Add new category: </h2>
<form action="/categories/create" method="post">
    Name: <input type="text" name="name"/><br><br>
    Description: <input type="text" name="description"/><br><br>
    <input type="submit" value="Add"/>
</form>
<hr>
</body>
</html>