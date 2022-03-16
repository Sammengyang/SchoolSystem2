<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/3/16
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
           $("#btn1").click(function () {
               var tid=$("#tid").html();
               alert("tid "+tid);
               $("input[name='tid']").val(tid);
           });
        });
    </script>
</head>
<body>
    <div id="msg">
        <table class="table table-striped">
            <thead>
            <tr>
                <td>编号</td>
                <td>名字</td>
                <td>性别</td>
                <td>密码</td>
                <td>生日</td>
                <td>入学时间</td>
                <td>专业</td>
                <td>电话</td>
                <td>角色</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td id="tid">1234</td>
                <td>${stuInfo.sname}</td>
                <td>${stuInfo.gender}</td>
                <td>${stuInfo.pwd}</td>
                <td>${stuInfo.birthday}</td>
                <td>${stuInfo.inSchoolTime}</td>
                <td>${stuInfo.major}</td>
                <td>${stuInfo.tel}</td>
                <td>${stuInfo.role}</td>
                <td>
                    <button type="button" id="btn1" class="btn btn-primary" data-toggle="modal" data-target="#bs-example-modal-lg">Large modal</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div id="motaikuang">
        <!-- Large modal -->
        <div class="modal fade" id="bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div id="data" style="padding: 20px">
                        <form action="GetAllStuScoreServlet">
                            编号:<input type="text" value="" name="tid"><br>
                            名字:<input type="text" value="" name="sname"><br>
                            密码:<input type="text" value="" name="pwd"><br>
                            <button type="submit">确认修改</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
