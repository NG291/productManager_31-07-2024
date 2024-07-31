<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 7/30/2024
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Ma product</th>
        <th>Ten san pham</th>
        <th>Gia san pham</th>
        <th>Mo ta</th>
        <th>Hang san xuat</th>
    </tr>
    <c:forEach items="${products}" var="p">
    <tr>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.price}</td>
        <td>${p.describe}</td>
        <td>${p.producer}</td>
        <td><a href="/products?action=edit&index=${p.id}">edit</a> </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
