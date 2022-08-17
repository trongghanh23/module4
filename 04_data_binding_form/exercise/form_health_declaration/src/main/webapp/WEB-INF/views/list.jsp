<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/8/2022
  Time: 3:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="text-align: center">DANH SÁCH TỜ KHAI BÁO Y TẾ</h3>
<div style="text-align: center">
    <a href="/create"><input type="button" value="Create"></a>
</div>
<table id="tableCustomer" class="table table-striped table-hover" border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Năm sinh</th>
        <th>Giới tính</th>
        <th>Quốc tịch</th>
        <th>Số CMND</th>
        <th>Thông tin đi lại</th>
        <th>Số hiệu phương tiện</th>
        <th>Số ghế</th>
        <th>Ngày khởi hành</th>
        <th>Ngày kết thúc</th>
        <th>Trong vòng 14 ngày qua có đi đến thành phố nào không?</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="medicalDeclaration" items="${medicalDeclaration}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${medicalDeclaration.name}</td>
            <td>${medicalDeclaration.birthday}</td>
            <td>${medicalDeclaration.gender}</td>
            <td>${medicalDeclaration.country}</td>
            <td>${medicalDeclaration.idCard}</td>
            <td>${medicalDeclaration.vehicle}</td>
            <td>${medicalDeclaration.vehicleNumber}</td>
            <td>${medicalDeclaration.chairNumber}</td>
            <td>${medicalDeclaration.startDay}/${medicalDeclaration.startMonth}/${medicalDeclaration.startYear}</td>
            <td>${medicalDeclaration.endDay}/${medicalDeclaration.endMonth}/${medicalDeclaration.endYear}</td>
            <td>${medicalDeclaration.route}</td>
            <td><a href="/edit?idCard=${medicalDeclaration.idCard}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
