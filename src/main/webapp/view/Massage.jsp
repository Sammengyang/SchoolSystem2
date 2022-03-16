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
            $("#but1").click(function () {
                // 找到同行的id
                var id = $(this).parent().parent().children().eq(0).text();
                // 获同行的标题
                var title = $(this).parent().parent().children().eq(1).text();
                // 获取同行的发布内容
                var texts = $(this).parent().parent().children().eq(2).text();
                // 发布人
                var pname = $(this).parent().parent().children().eq(3).text();
                // 发布时间
                var posttime = $(this).parent().parent().children().eq(4).text();
                $("#myModalLabel").html(title);
                $("#myModalLabel2").html(posttime);
                $("#mytext").html(texts);
                $("#pname").html(pname);

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
                    <a id="but1"> <!--// todo 只能第一个按钮获取到信息-->
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                            查看
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                <div style="float: right">
                    发布时间:<spamn id="myModalLabel2"></spamn>
                </div>
            </div>
            <div class="modal-body" id="mytext">

            </div>
            <div class="modal-footer">
                <div style="float: left">
                    发布人:<span id="pname"></span>
                </div>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
