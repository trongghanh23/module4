<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/8/2022
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculators" method="get">
    <h1>Calculator</h1>
    <input type="text" name="number1">
    <input type="text" name="number2"><br>
    <hr>
    <input type="submit" name="operator" value="Addition(+)">
    <input type="submit" name="operator" value="Subtraction(-)">
    <input type="submit" name="operator" value="Multiplication(*)">
    <input type="submit" name="operator" value="Division(/)">
</form>
<p>
    Result:${result}
</p>

</body>
</html>
