<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/15
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>假条审批</title>
    <script src="/js/jquery-3.6.0.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous"></script>

    <script>
        $(function (){
            $("#success").click(function (){
                // 找到同行的id
                var id = $(this).parent().parent().children().eq(0).text();
                $.ajax({// todo 82 行跳转servlet取消，数据传输过去，jQuery中跳转servlet
                    type:"POST",
                    url:"/PermitServlet",//要达到的地址，这里填的是相对地址
                    data:"username="+id,// 数据
                    dataType:"text",//数据类型
                    success : function(data,textStatus)
                    {
                        $("#result1").text(data);
                        $("#result1").css("color","red");
                    }
                });
            });

            $("#false").click(function (){
                // 找到同行的id
                var id = $(this).parent().parent().children().eq(0).text();
            });
        });
    </script>
</head>
<body>
<div>
    <table class="table table-hover">
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>请假原因</td>
            <td>离校时间</td>
            <td>返校时间</td>
            <td>状态</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${leaveList}" var="el">
            <tr>
                <td>${el.sid}</td>
                <td>${el.sname}</td>
                <td>${el.text}</td>
                <td>${el.startTime}</td>
                <td>${el.endTime}</td>
                <c:if test="${el.state =='已批准'}">
                    <td>${el.state}</td>
                </c:if>
                <c:if test="${el.state=='已拒绝'}">
                    <td>${el.state}</td>
                </c:if>
                <c:if test="${el.state=='' or el.state== null}">
                    <td>
                        <a id="success" href="">
                            <button type="button" class="btn btn-success">同意</button>
                        </a>
                        <a id="false" href="/PermitServlet">
                            <button type="button" class="btn btn-danger">拒绝</button>
                        </a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
