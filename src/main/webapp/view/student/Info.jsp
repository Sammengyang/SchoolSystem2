<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<%@ page import="com.zmy.pojo.student.Student" %><%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/10
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.6.0.js" type="text/javascript"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

    <script>
        $(function (){
            $("#but1").click(function () {
                // 点击修改获取表格数据
                $("input[name='sid']").val($("#sid").text());
                $("input[name='sname']").val($("#sname").text());
                $("input[name='pwd']").val($("#pwd").text());
                $("input[name='sex']").val($("#sex").text());
                $("input[name='bir']").val($("#bir").text());
                $("input[name='insc']").val($("#insc").text());
                $("input[name='major']").val($("#major").text());
                $("input[name='cid']").val($("#cid").text());
                $("input[name='tel']").val($("#tel").text());
            });

            $("#but2").click(function () {
                // 点击修改获取表格数据
                $("input[name='tid']").val($("#tid").text());
                $("input[name='tname']").val($("#tname").text());
                $("input[name='pwd']").val($("#tpwd").text());
                $("input[name='insc']").val($("#tinsc").text());
                $("input[name='role']").val($("#role").text());
                $("input[name='tel']").val($("#ttel").text());
            });
        });
    </script>
</head>
<body>
    <c:if test="${role=='student'}">
        <table class="table table-hover">
            <tr>
                <td>学号:</td>
                <td id="sid">${stuinfo.sid}</td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td id="sname">${stuinfo.sname}</td>
            </tr>
            <tr>
                <td>密码:</td>
                <td id="pwd">${stuinfo.pwd}</td>
            </tr>
            <tr>
                <td>性别:</td>
                <td id="sex">${stuinfo.gender}</td>
            </tr>
            <tr>
                <td>生日:</td>
                <td id="bir">${stuinfo.birthday}</td>
            </tr>

            <tr>
                <td>入学时间:</td>
                <td id="insc">${stuinfo.inschool_time}</td>
            </tr>
            <tr>
                <td>专业:</td>
                <td id="major">${stuinfo.major}</td>
            </tr>
            <tr>
                <td>班级:</td>
                <td id="cid">${stuinfo.cid}</td>
            </tr>
            <tr>
                <td>手机号:</td>
                <td id="tel">${stuinfo.tel}</td>
            </tr>
        </table>
        <a id="but1">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                修改
            </button>
        </a>
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Personal Information</h4>
                    </div>
                    <div class="modal-body">
                        <form action="/ChangeInfoServlet" method="post">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon1">学号</span>
                                <input type="text" class="form-control" name="sid" placeholder="学号" readonly="readonly" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon2">姓名</span>
                                <input type="text" class="form-control" name="sname" placeholder="姓名" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon9">密码</span>
                                <input type="text" class="form-control" name="pwd" placeholder="密码" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon3">性别</span>
                                <input type="text" class="form-control" name="sex" placeholder="性别" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon4">生日</span>
                                <input type="text" class="form-control" name="bir" placeholder="生日" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon5">入学时间</span>
                                <input type="text" class="form-control" name="insc" placeholder="入学时间" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon6">专业</span>
                                <input type="text" class="form-control" name="major" placeholder="专业" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon7">班级</span>
                                <input type="text" class="form-control" name="cid" placeholder="班级" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon8">手机号</span>
                                <input type="text" class="form-control" name="tel" placeholder="手机号" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="modal-footer" style="margin-left: 200px">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${role=='teacher'}">
        <table class="table table-hover">
            <tr>
                <td>教师编号:</td>
                <td id="tid">${myInfo.tid}</td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td id="tname">${myInfo.tname}</td>
            </tr>
            <tr>
                <td>密码:</td>
                <td id="tpwd">${myInfo.pwd}</td>
            </tr>
            <tr>
                <td>职位:</td>
                <td id="role">${myInfo.role}</td>
            </tr>
            <tr>
                <td id="tinsc">入职时间:</td>
                <td>${myInfo.inschool_time}</td>
            </tr>
            <tr>
                <td id="ttel">手机号:</td>
                <td>${myInfo.tel}</td>
            </tr>
        </table>

        <a id="but2">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                修改
            </button>
        </a>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel1">Personal Information</h4>
                    </div>
                    <div class="modal-body">
                        <form action="/TeaChangeInfoServlet" method="post">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon11">教师编号</span>
                                <input type="text" class="form-control" name="tid" placeholder="教师编号" readonly="readonly" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon22">姓名</span>
                                <input type="text" class="form-control" name="tname" placeholder="姓名" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon33">密码</span>
                                <input type="text" class="form-control" name="pwd" placeholder="密码" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon44">入职时间</span>
                                <input type="text" class="form-control" name="insc" placeholder="入学时间" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon55">职位</span>
                                <input type="text" class="form-control" name="role" placeholder="值位" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon" id="sizing-addon66">手机号</span>
                                <input type="text" class="form-control" name="tel" placeholder="手机号" aria-describedby="sizing-addon3">
                            </div><br>
                            <div class="modal-footer" style="margin-left: 200px">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </c:if>

</body>
</html>
