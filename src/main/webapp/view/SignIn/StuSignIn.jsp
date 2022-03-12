<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/12
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="/js/jquery-3.6.0.js" type="text/javascript"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <script type="text/javascript">
        $(function (){
            $("input[name='username']").blur(function (){
                var uname = $("input[name='username']").val();
                $.ajax({
                    type:"GET", // 提交数据类型
                    url:"SignInServlet", // 提交到哪个服务器
                    data:"username"+uname, // 提交的数据
                    dataType:"text", // 提交的数据类型
                    success:function (d){ // d 回调函数 ，服务器执行完之后，接收服务器响应的数据
                        alert("d"+d);
                        if (d=="success"){
                            $("div>span").html("存在1111");
                        }else{
                            $("div>span").html("错误");
                        }
                    },
                    error:function (d,errorThrown){
                        $("#div").text(d.responseText+" "+d.status+"  "+d.readyState+" "+errorThrown);
                    },
                });
            });
        });
        function goSignUp(){
            window.location.href="../view/SignUp/Sign_up.jsp";
        }
    </script>
    <style>
        #login{
            margin-top: 110px;
            margin-left: 700px;
            width: 450px;
        }
        #exist{
            position: absolute;
            top: 110px;
            left: 1180px;
            font-size: 20px;
            color: red;
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
</head>
<body>
    <%
        String role = "student";
        session.setAttribute("role",role);
    %>
<div id="login" class="center-block">
    <form action="SignInServlet" method="post">
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="sid" >账号</span>
            <input type="text" class="form-control" value="" name="sid" placeholder="sid" aria-describedby="sizing-addon1">
        </div><br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="username" >姓名</span>
            <input type="text" class="form-control" value="" name="username" placeholder="Name" aria-describedby="sizing-addon1">
        </div><br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="password" >密码</span>
            <input type="password" class="form-control" name="password" placeholder="password" aria-describedby="sizing-addon1">
        </div><br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="rpassword" >确认密码</span>
            <input type="password" class="form-control" name="password" placeholder="password" aria-describedby="sizing-addon1">
        </div><br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon" id="tel" >电话</span>
            <input type="text" class="form-control" name="tel" placeholder="tel" aria-describedby="sizing-addon1">
        </div><br>
        <div>
            <input type="radio" name="role" value="student"> student
            <input type="radio" name="role" value="teacher"> teacher
        </div>
        <button type="submit" class="btn btn-default" style="width: 200px;height: 40px;margin-left: 25px">注册</button>
        <button type="button" class="btn btn-default" style="width: 200px;height: 40px" onclick="">登录</button>
    </form>
</div>
<div id="exist">
    <span>存在</span>
</div>
</body>
</html>
