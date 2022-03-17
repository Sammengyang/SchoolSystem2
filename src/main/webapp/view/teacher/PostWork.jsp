<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/17
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布作业</title>
    <script src="/js/jquery-3.6.0.js" type="text/javascript"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <style>
        #div1{
            width: 800px;
            height: 800px;
            margin-top: 100px;
            margin-left: 100px;
        }
    </style>
</head>
<body>
<div id="div1">
    <form class="form-horizontal" action="/PostWorkServlet" method="post">
        <div class="form-group">
            <label for="tid" class="col-sm-2 control-label">发 布 人</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="tid"  readonly="readonly" value="${user.tid}">
            </div>
        </div>
        <div class="form-group">
            <label for="tid" class="col-sm-2 control-label">发布班级</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="cid" name="cid">
            </div>
        </div>
        <div class="form-group">
            <label for="startTime" class="col-sm-2 control-label">发布时间</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="startTime" name="startTime">
            </div>
        </div>
        <div class="form-group">
            <label for="endTime" class="col-sm-2 control-label">发布时间</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="endTime" name="endTime">
            </div>
        </div>
        <div class="form-group">
            <label for="work" class="col-sm-2 control-label">作业内容</label>
            <div class="col-sm-10">
                <textarea type="text" class="form-control" name="work" id="work" placeholder="作业内容....." style="height: 100px;resize: none" ></textarea>
            </div>
        </div><br><br>
        <div class="col-sm-offset-2 col-sm-10" style="margin-left: 400px">
            <button type="submit" class="btn btn-success">发  布</button>
        </div>
    </form>
</div>
</body>
</html>
