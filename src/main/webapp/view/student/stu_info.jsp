<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<%@ page import="com.zmy.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/10
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>
    <c:if test="${role=='student'}">
        <table class="table table-hover">
            <tr>
                <td>学号:</td>
                <td>${user.sid}</td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td>${user.sname}</td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>${user.gender}</td>
            </tr>
            <tr>
                <td>生日:</td>
                <td>${user.birthday}</td>
            </tr>

            <tr>
                <td>入学时间:</td>
                <td>${user.inschool_time}</td>
            </tr>
            <tr>
                <td>专业:</td>
                <td>${user.major}</td>
            </tr>
            <tr>
                <td>班级:</td>
                <td>${user.cid}</td>
            </tr>
            <tr>
                <td>手机号:</td>
                <td>${user.tel}</td>
            </tr>
        </table>
    </c:if>
    <c:if test="${role=='teacher'}">
        <table class="table table-hover">
            <tr>
                <td>教师编号:</td>
                <td>${user.tid}</td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td>${user.tname}</td>
            </tr>
            <tr>
                <td>密码:</td>
                <td>${user.pwd}</td>
            </tr>
            <tr>
                <td>职位:</td>
                <td>${user.role}</td>
            </tr>
            <tr>
                <td>入职时间:</td>
                <td>${user.inschool_time}</td>
            </tr>
            <tr>
                <td>手机号:</td>
                <td>${student.tel}</td>
            </tr>
        </table>
    </c:if>
</body>
</html>
