<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/8/2022
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/save">
    <c:forEach items="${listSpice}" var="listSpice">
        <input type="checkbox" name="spice" value="${listSpice}">
        <label>${listSpice}</label>
    </c:forEach>
    <br>
    <button type="submit">save</button>
</form>
<ol>
    <c:forEach var="spiceSwich" items="${spice}">

        <li>${spiceSwich}</li>

    </c:forEach>
</ol>
</body>
</html>
