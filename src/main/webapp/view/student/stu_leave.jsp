<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/10
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请假</title>
    <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>
<form action="/StuLeaveServlet" method="post">
    <div style="margin-left: 700px;width: 220px" class="alert alert-success" role="alert">
        <h1>请假申请表</h1>
    </div>
    <div>
        <div class="input-group input-group-lg">
            <td>
                <span class="input-group-addon">学号</span>
                <input type="text" class="form-control" name="sid" placeholder="sid" aria-describedby="sizing-addon1">
            </td>
        </div><br><br>
        <div class="input-group input-group-lg">
            <td>
                <span class="input-group-addon">姓名</span>
                <input type="text" class="form-control" name="sname" placeholder="Name" aria-describedby="sizing-addon1">
            </td>
        </div><br><br>
        <div class="input-group input-group-lg">
            <td>
                <span class="input-group-addon">审批人</span>
                <input type="text" class="form-control" name="tid" placeholder="Tid" aria-describedby="sizing-addon1">
            </td>
        </div><br><br>
        <div class="input-group input-group-lg">
            <td>
                <span class="input-group-addon">请假事由</span>
                <input type="text" class="form-control" name="texts" placeholder="Text" aria-describedby="sizing-addon1">
            </td>
        </div><br><br>
        <div class="input-group input-group-lg">
            <td>
                <span class="input-group-addon">起始时间</span>
                <input type="text" class="form-control" name="startTime" placeholder="StartTime" aria-describedby="sizing-addon1">
            </td>
        </div><br><br>
        <div class="input-group input-group-lg">
            <td>
                <span class="input-group-addon">截至时间</span>
                <input type="text" class="form-control" name="endtime" placeholder="EndTime" aria-describedby="sizing-addon1">
            </td>
        </div><br><br>
        <div class="input-group input-group-lg">
            <td>
                <span class="input-group-addon">手机号</span>
                <input type="text" class="form-control" name="tel" placeholder="Telphone" aria-describedby="sizing-addon1">
            </td>
        </div>
    </div><br><br>
    <button style="margin-left: 750px" type="submit" class="btn btn-primary btn-lg">提   交</button>
</form>
</body>
</html>
