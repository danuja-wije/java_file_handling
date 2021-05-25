<%--
  Created by IntelliJ IDEA.
  User: Kavindu Balasooriya
  Date: 5/22/2021
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form</title>
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<div>
    <h1 class="TtxtStyle">Advertisment</h1><br>
    <form id="formStyle1" action="${pageContext.request.contextPath}/AdController?action=ADD" method="post" enctype="multipart/form-data">
        <input type="text" name="username" id="username" placeholder="User Name"><br>
        <input type="text" name="adname" id="adname" placeholder="Add Title"><br>
        <select name="category">
            <option value="education">education</option>
            <option value="entertainment">entertainment</option>
            <option value="health">health care</option>
            <option value="foods">foods</option>
            <option value="others">others</option>
        </select><br>
        <select name="type">
            <option value="video">video</option>
            <option value="image">image</option>
        </select><br>
        <select name="period">
            <option value="day">1 day</option>
            <option value="week">7 days</option>
            <option value="two-weeks">14 days</option>
            <option value="month">28 days</option>
        </select><br>
        <input type="file" name="thumbFile" id="name" accept="image/*"><br>
        <input type="file" name="file" id="name"><br>

        <button class="Btn">confirm</button>
    </form>
</div>

</body>
</html>
