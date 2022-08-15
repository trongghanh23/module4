<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/8/2022
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style l></style>
</head>
<body>
<form action="/search" method="post">
    <p>Input English</p>
    <input type="text" name="language">
    <input type="submit" value="convert">

</form>
<p>Result:${result}</p>
</body>
</html>
