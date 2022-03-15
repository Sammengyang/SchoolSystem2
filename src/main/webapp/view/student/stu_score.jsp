<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.zmy.servlet.stu.ScoreServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.zmy.pojotrait.Stu_score" %>
<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/10
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>历史成绩</title>
    <script src="/js/jquery-3.6.0.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

    <script>
        $(function (){
            $("#gotoPage").click(function (){
                var page = $("input[name='pageNum']").val();
                var str = /^[1-9]\d*$/; // 非零正整数
                if (str.exec(page)){
                    $("#postForm").submit();
                }
            });
        });
    </script>
    <style>
        #paging{
            width: 800px;
            position: absolute;
            bottom: 30px;
            left: 700px;
        }
    </style>
</head>
<body>
<div>
    <table class="table table-hover">
        <thead>
        <tr>
            <td>考试编号</td>
            <td>学号</td>
            <td>专业</td>
            <td>课程名称</td>
            <td>学分</td>
            <td>分数</td>
            <td>考试时间</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${scores}" var="el">
            <tr>
                <td>${el.id}</td>
                <td>${el.sid}</td>
                <td>${el.major}</td>
                <td>${el.cname}</td>
                <td>${el.credit}</td>
                <td>${el.score}</td>
                <td>${el.exam_time}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div id="paging">
    <nav aria-label="Page navigation">
        <ul class="pagination pagination-lg">
            <li><a href="/ScoreServlet?pageNum=1">首页</a></li>
            <li><a href="/ScoreServlet?pageNum=${sessionScope.pageNum-1}">上一页</a></li>
            <li><a href="#">${sessionScope.pageNum}</a></li>
            <li><a href="/ScoreServlet?pageNum=${sessionScope.pageNum+1}">下一页</a></li>
            <li><a href="/ScoreServlet?pageNum=${sessionScope.maxPageSize}">末页</a></li>
            <li><span>共&nbsp;${sessionScope.maxPageSize}&nbsp;页</span></li>
        </ul>
        <form action="/ScoreServlet" method="post" id="postForm">
            到第<input type="text" name="pageNum" value="">页
        </form>
        <button type="button" id="gotoPage">确定</button>
    </nav>
</div>
</body>
</html>
