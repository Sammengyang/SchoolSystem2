<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/17
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业情况</title>
</head>
<body>










<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel1">HomeWork</h4>
            </div>
            <div class="modal-body">
                <form action="/SubmitWorkServlet" method="post">
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon" id="sizing-addon1">提交人</span>
                        <input type="text" class="form-control" readonly="readonly" name="tname" readonly="readonly" aria-describedby="sizing-addon3">
                    </div><br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon" id="sizing-addon2">班级</span>
                        <input type="text" class="form-control" readonly="readonly" name="cid"  aria-describedby="sizing-addon3">
                    </div><br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon" id="sizing-addon3">作业内容</span>
                        <input type="text" class="form-control" name="texts" readonly="readonly" aria-describedby="sizing-addon3">
                    </div><br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon" id="sizing-addon5">提交时间</span>
                        <input type="text" class="form-control"  name="submitWork" aria-describedby="sizing-addon3">
                    </div><br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon" id="sizing-addon7">作业</span>
                        <textarea type="text" class="form-control"  name="mywork"  aria-describedby="sizing-addon3" style="height: 100px;resize: none"></textarea>
                    </div><br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon" id="sizing-addon6">成绩</span>
                        <input type="text" class="form-control"  name="score" readonly="readonly"  aria-describedby="sizing-addon3">
                    </div><br>
                    <div class="modal-footer" style="margin-left: 200px">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交批改</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


</body>
</html>
