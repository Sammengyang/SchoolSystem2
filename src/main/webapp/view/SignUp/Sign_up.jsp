<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/10
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="/js/jquery-3.6.0.js" type="text/javascript"></script>
    <style>
        #register{
            margin-top: 300px;
            margin-left: 700px;
            width: 450px;
        }
        body{
            background-image: url("/img/canvas4.png");
            background-repeat: no-repeat;
        }
        .center-block {
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<%
    //登录失败后账号框的数据存入cookie
    String username="";
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
        if ("username".equals(cookies[i].getName())){
            username=cookies[i].getValue();
        }
    }
    System.out.println(username);
%>
<div id="register" class="center-block">
    <form action="StuServlet" method="post">
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="username" >账号</span>
            <input type="text" class="form-control" value="<%=username%>" name="username" placeholder="Username" aria-describedby="sizing-addon1">
        </div><br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="password" >密码</span>
            <input type="password" class="form-control" name="password" placeholder="password" aria-describedby="sizing-addon1">
        </div><br>
        <div>
            <input type="radio" name="role" value="student"> student
            <input type="radio" name="role" value="teacher"> teacher
        </div>
        <div>
            <button type="submit" class="btn btn-default" style="width: 450px;height: 40px">登录</button>
        </div><br>
        <div style="float: right">
            <a href="/view/SignIn/StuSignIn.jsp">注册</a>
        </div>
    </form>

</div>
</body>
</html>
