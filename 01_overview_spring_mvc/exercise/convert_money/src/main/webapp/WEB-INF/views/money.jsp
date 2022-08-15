<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2022
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/convert/money/vn" >
    <p>Nhập số tiền:</p>
    <input type="number" name="usd">USD
    <input type="submit" name="submit" value="submit">

</form>
<table >
    <tr>
        <td>Result</td>
        <td> ${result}VND</td>
    </tr>
</table>
</body>
</html>
