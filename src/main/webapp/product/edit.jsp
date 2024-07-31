<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 7/30/2024
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Day la form</h1>
<form method="post">
    <input type="text" value="${product.id}" name="id"/>
    <input type="text" value="${product.name}" name="name"/>
    <input type="text" value="${product.price}" name="price"/>
    <input type="text" value="${product.describe}" name="describe"/>
    <input type="text" value="${product.producer}" name="producer"/>
    <button type="submit">Edit</button>
</form>
</body>
</html>

