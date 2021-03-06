<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/15
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请假历史</title>
    <script src="/js/jquery-3.6.0.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>
<div>
    <table class="table table-hover">
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>审批人id</td>
            <td>审批人姓名</td>
            <td>请假原因</td>
            <td>请假时间</td>
            <td>返校时间</td>
            <td>状态</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${historyHoliday}" var="el">
            <tr>
                <td>${el.sid}</td>
                <td>${el.sname}</td>
                <td>${el.tid}</td>
                <td>${el.tname}</td>
                <td>${el.text}</td>
                <td>${el.startTime}</td>
                <td>${el.endTime}</td>
                <td>${el.state}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
