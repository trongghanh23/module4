<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/8/2022
  Time: 5:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Tờ khai y Tế</h1>
        <h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ, SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG
            CHỐNG DỊCH BỆNH TRUYỀN NHIỂM</h4>
        <p>Khuyến cáo: khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>

    </div>

    <form:form modelAttribute="HealthDeclaration" method="post" action="/update">

    <div class="row">
        <p>Họ Tên (ghi chữ in hoa</p>
        <form:input path="name"></form:input>
    </div>

    <div class="row">
        <div class="col-4">
            <div class="row">
                <p>Năm sinh</p>
                <form:select path="birthday" items="${birthday}"></form:select>
            </div>

        </div>
        <div class="col-4">
            <div class="row">
                <p>Giới tính</p>
                <form:select path="gender" items="${gender}"></form:select>
            </div>

        </div>
        <div class="col-4">
            <div class="row">
                <p>Quốc tịch</p>
                <form:select path="country" items="${country}"></form:select>
            </div>

        </div>

    </div>
    <div class="row">
        <p>Số hộ chiếu hoặc số chứng minh hoặc giấy thông hành khác</p>
        <form:input path="idCard"></form:input><br>

    </div>
    <div class="row">
        <p>Thông tin đi lại</p>
        <form:radiobuttons path="vehicle" items="${vehicle}"></form:radiobuttons><br>

    </div>
    <div class="row">
        <p>Số hiệu phương tiện</p>
        <form:input path="vehicleNumber"></form:input>

    </div>
    <div class="row">
        <p>Số ghế</p>
        <form:input path="chairNumber"></form:input>

    </div>

    <div class="row">
        <div class="col-6">
            <div class="row">
                <p>Ngày khởi hành</p>
            </div>

            <div class="row">
                <div class="col-4"><form:select path="startDay" items="${day}"></form:select></div>
                <div class="col-4"><form:select path="startMonth" items="${month}"></form:select></div>
                <div class="col-4"><form:select path="startYear" items="${year}"></form:select></div>
            </div>
        </div>

        <div class="col-6">
            <div class="row"><p>Ngày kết thúc</p></div>

            <div class="row">
                <div class="col-4"><form:select path="endDay" items="${day}"></form:select></div>
                <div class="col-4"><form:select path="endMonth" items="${month}"></form:select></div>
                <div class="col-4"><form:select path="endYear" items="${year}"></form:select><br></div>
            </div>
        </div>
    </div>

</div>
<div class="row">
    <p>Trong vòng 14 ngày qua anh/chị có đến tỉnh/thành phố nào?</p>
    <form:input path="route"></form:input>

</div>
<button type="submit">Lưu</button>
</div>
</form:form>
</body>
</html>
