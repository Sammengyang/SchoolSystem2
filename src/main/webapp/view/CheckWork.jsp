<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/17
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检查作业</title>
    <script src="../js/jquery-3.6.0.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/main/webapp/layui/css/layui.css">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <script>
        $(function (){
            $("a[class='w1']").click(function (){
                // 找到同行的id
                var title = $(this).parent().parent().children().eq(2).text();
                alert(title);
                $.ajax({
                    type:"GET",
                    url:"/PermitServlet",//要达到的地址，这里填的是相对地址
                    data:{"title=":title,""},// 数据
                    dataType:"text",//数据类型
                });
                /* todo
                    学生提交完作业，老师无法查看到本次作业学生提交的记录？
                 */
                // 刷新当前页面
                location.reload();
            });
            $("a[class='but1']").click(function () {
                var tname = $(this).parent().parent().children().eq(0).text();
                var cid = $(this).parent().parent().children().eq(1).text();
                var text = $(this).parent().parent().children().eq(2).text();
                var endTime = $(this).parent().parent().children().eq(3).text();
                var submitWork = $(this).parent().parent().children().eq(4).text();
                var score = $(this).parent().parent().children().eq(5).text();
                if (score==0){
                    score="";
                }
                // 点击修改获取表格数据
                $("input[name='tname']").val(tname);
                $("input[name='cid']").val(cid);
                $("input[name='texts']").val(text);
                $("input[name='endTime']").val(endTime);
                $("input[name='submitWork']").val(submitWork);
                $("input[name='score']").val(score);
            });
        });
    </script>
</head>
<body>
<c:if test="${role =='student'}">
    <div>
        <table class="table table-hover">
            <thead>
            <tr>
                <td>发布人</td>
                <td>课程</td>
                <td>作业</td>
                <td>截至日期</td>
                <td>提交时间</td>
                <td>作业内容</td>
                <td>分数</td>
                <td>提交作业</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${stuHomeWork}" var="el">
                <tr>
                    <td>${el.tname}</td>
                    <td>${el.cid}</td>
                    <td>${el.text}</td>
                    <td>${el.endTime}</td>
                    <td>${el.postTime}</td>
                    <td>${el.jobContent}</td>
                    <td>${el.score}</td>
                    <c:if test="${el.score>0 || el.score > 60}">
                        <td id="td1">
                            <button name="b1" type="button" class="btn btn-success ">提交</button>
                        </td>
                    </c:if>
                    <c:if test="${el.score<60}">
                        <td>
                            <a class="but1">
                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                                    提交
                                </button>
                            </a>
                            <a class="but1">
                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                                    修改
                                </button>
                            </a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">HomeWork</h4>
                </div>
                <div class="modal-body">
                    <form action="/SubmitWorkServlet" method="post">
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon" id="sizing-addon11">发布人</span>
                            <input type="text" class="form-control" readonly="readonly" name="tname" readonly="readonly" aria-describedby="sizing-addon3">
                        </div><br>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon" id="sizing-addon22">班级</span>
                            <input type="text" class="form-control" readonly="readonly" name="cid"  aria-describedby="sizing-addon3">
                        </div><br>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon" id="sizing-addon33">作业内容</span>
                            <input type="text" class="form-control" name="texts" readonly="readonly" aria-describedby="sizing-addon3">
                        </div><br>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon" id="sizing-addon44">截至日期</span>
                            <input type="text" class="form-control"  name="endTime" readonly="readonly" aria-describedby="sizing-addon3">
                        </div><br>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon" id="sizing-addon55">提交时间</span>
                            <input type="text" class="form-control"  name="submitWork" aria-describedby="sizing-addon3">
                        </div><br>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon" id="sizing-addon66">成绩</span>
                            <input type="text" class="form-control"  name="score" readonly="readonly"  aria-describedby="sizing-addon3">
                        </div><br>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon" id="sizing-addon77">作业</span>
                            <textarea type="text" class="form-control"  name="mywork"  aria-describedby="sizing-addon3" style="height: 100px;resize: none"></textarea>
                        </div><br>
                        <div class="modal-footer" style="margin-left: 200px">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">确认提交</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>


</c:if>

<c:if test="${role=='teacher'}">
    <div>
        <table class="table table-hover">
            <thead>
            <tr>
                <td>班级</td>
                <td>作业内容</td>
                <td>发布时间</td>
                <td>截至日期</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${homeWorkList}" var="el">
                <tr>
                    <td>${el.cid}</td>
                    <td>${el.text}</td>
                    <td>${el.startTime}</td>
                    <td>${el.endTime}</td>
                    <td>
                        <a class="w1" href="/WorkConditionServlet"><button name="but1">查看提交情况</button></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>



</c:if>
</body>
</html>
