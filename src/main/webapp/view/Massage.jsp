<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/16
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看消息</title>
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
           $("#view").click(function (){
               // 找到同行的id
               var id = $(this).parent().parent().children().eq(0).text();
               alert(id);
               $.ajax({
                   async: false,
                   type:"GET",
                   url:"/ViewMassageServlet",//要达到的地址，这里填的是相对地址
                   data:{"id":id,"state":"已读"},// 数据
                   dataType:"text",//数据类型
                   success:function (d){ //服务器执行完之后，接收服务器响应的数据
                       alert("d"+d);
                       if (d=="success"){
                           $(this).parent().html("111");
                       }else{
                           $(this).parent().html("2222");
                       }
                   },
                   error:function (d,errorThrown){
                       $(this).parent().html("3333");
                   },
               });
           });

            $("#lose").click(function (){
                // 找到同行的id
                var id = $(this).parent().parent().children().eq(0).text();
                alert(id);
                $.ajax({
                    async: false,
                    type:"GET",
                    url:"/ViewMassageServlet",//要达到的地址，这里填的是相对地址
                    data:{"id":id,"state":"忽略"},// 数据
                    dataType:"text",//数据类型
                    success:function (d){ //服务器执行完之后，接收服务器响应的数据
                        alert("d"+d);
                        if (d=="success"){
                            $(this).parent().html("111");
                        }else{
                            $(this).parent().html("2222");
                        }
                    },
                    error:function (d,errorThrown){
                        $(this).parent().html("3333");
                    },
                });
            });
        });
    </script>
</head>
<body>
<div>
    <table class="table table-hover">
        <thead>
        <tr>
            <td>消息编号</td>
            <td>标题</td>
            <td>发布内容</td>
            <td>发布人</td>
            <td>发布时间</td>
            <td>状态</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${massage}" var="el">
            <tr>
                <td>${el.id}</td>
                <td>${el.title}</td>
                <td>${el.text}</td>
                <td>${el.pname}</td>
                <td>${el.postTime}</td>
                <td class="td1">
                    <a class="view" href="">
                        <button type="button" class="btn btn-success">查看</button>
                    </a>&nbsp;
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
