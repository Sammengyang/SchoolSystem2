<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
            $("#b1").click(function (){
                //找到同行的id
                var id = $(this).parent().parent().children().eq(0).text();
                var startTime = $(this).parent().parent().children().eq(3).text();
                $.ajax({ // todo 回调函数不执行 拒绝时无法发送数据到servlet
                    type:"GET",
                    url:"/PermitServlet",//要达到的地址，这里填的是相对地址
                    data:{"sid":id,"startTime":startTime,"state":"已批准"},// 数据
                    dataType:"text",//数据类型
                    // success:function (d){ // d 回调函数 ，服务器执行完之后，接收服务器响应的数据
                    //     alert("d"+d);
                    //     if (d=="success"){
                    //         alert("success")
                    //         $(this).parent().html("已批准");
                    //     }else{
                    //        $(this).parent().html("已拒绝");
                    //     }
                    // },
                    // error:function (d,errorThrown){
                    //     $(this).parent().html("");
                    // },
                });
                // 刷新当前页面
                location.reload();
            });

            $("#b2").click(function (){
                // 找到同行的id
                var sid = $(this).parent().parent().children().eq(0).text();
                var startTime = $(this).parent().parent().children().eq(3).text();
                $.ajax({
                    type:"GET",
                    url:"/PermitServlet",//要达到的地址，这里填的是相对地址
                    data:{"sid":sid,"startTime":startTime,"state":"已拒绝"},// 数据
                    dataType:"text",//数据类型
                    // success:function (d){ // d 回调函数 ，服务器执行完之后，接收服务器响应的数据
                    //     alert("d"+d);
                    //     if (d=="success"){
                    //        // $(this).parent().html("已拒绝");
                    //
                    //     }else{
                    //         $(this).parent().html("已批准");
                    //     }
                    // },
                    // error:function (d,errorThrown){
                    //     $(this).parent().html("");
                    // },
                });
                // 刷新当前页面
                location.reload();
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
                    <td id="td1">
                        <button id="b1" type="button" class="btn btn-success ">同意</button>
                        <button id="b2" type="button" class="btn btn-danger">拒绝</button>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
