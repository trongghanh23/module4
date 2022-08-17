<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/8/2022
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Form email</h2>
<form:form method="post" action="/email" modelAttribute="email">
    <table>
        <tr>
            <td>Language:</td>
            <td><form:select path="language" items="${language}"></form:select></td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td> show <form:select path="size" items="${size}"></form:select> emails per page</td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td><form:checkbox path="spams"></form:checkbox> Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Update</button>
                <button type="reset">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
