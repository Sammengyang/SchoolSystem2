<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学生教务系统</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="/js/jquery-3.6.0.js"></script>
    <%
        Cookie[] cookies = request.getCookies();
        String sid = String.valueOf(cookies[0]);
    %>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#nav1").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#nav2").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#nav3").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#nav4").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });

            $("#nav5").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#nav6").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#nav7").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#stu_homework").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#stu_post_homework").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#info").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#leave").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#getMsg").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#tinfo").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#file").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });
            $("#getCourse").click(function (e) {
                e.preventDefault();
                $("#f1").attr("src",$(this).attr("href"));
            });

        });
    </script>
</head>
<%

%>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black"><img src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbkimg.cdn.bcebos.com%2Fpic%2Ff31fbe096b63f6246b6028138d09fcf81a4c510f05c4&refer=http%3A%2F%2Fbkimg.cdn.bcebos.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1649496736&t=d69e33270557ea73bec3daa7662adc2d" width="100%" height="100%"></div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left" lay-filter="test">
            <c:if test="${role =='student'}">
                <li class="layui-nav-item layui-hide-xs"><a id="nav1" href="/StuinfoServlet">个人信息</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="nav2" href="/ScoreServlet">历史成绩</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="nav3" href="stu_course.jsp">课表</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="nav4" href="stu_leave.jsp">请假申请</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="nav5" href="/StuHistoryHolidayServlet">请假记录</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="nav6" href="/GetMassageServlet">消息查看</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="nav7" href="/">查看作业</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="nav8" href="/">消息查看</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="nav9" href="stu_repairs.jsp">故障报修</a></li>
                <li class="layui-nav-item">
                    <a href="javascript:;">作业</a>
                    <dl class="layui-nav-child">
                        <dd><a id="stu_homework" href="stu_homework.jsp">查看作业</a></dd>
                        <dd><a id="stu_post_homework" href="stu_post_homework.jsp">提交作业</a></dd>
                    </dl>
                </li>
            </c:if>
            <c:if test="${role =='teacher'}">
                <li class="layui-nav-item layui-hide-xs"><a id="tinfo" href="/TeacherInifServlet">个人信息</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="leave" href="/leave_for_approvalServlet">请假审核</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="getScore" href="">发起调课</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="getCourse" href="/QueryAllScoreServlet">查看全班学生学分</a></li>
                <li class="layui-nav-item layui-hide-xs"><a id="getMsg" href="/GetMassageServlet">消息查看</a></li>
                <li class="layui-nav-item">
                    <a href="javascript:;">作业</a>
                    <dl class="layui-nav-child">
                        <dd><a id="CheckHomework" href="stu_homework.jsp">发布作业</a></dd>
                        <dd><a id="AssignHomework" href="stu_post_homework.jsp">审批作业</a></dd>
                    </dl>
                </li>
            </c:if>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    tester
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">Your Profile</a></dd>
                    <dd><a href="">Settings</a></dd>
                    <dd><a href="/SignOutServlet" id="signOut">Sign out</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">量化评教</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">量化评教</a></dd>
                        <dd><a href="javascript:;">教师分析</a></dd>
                        <dd><a href="javascript:;">课程分析</a></dd>
                        <dd><a href="">问卷调查</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">公共服务</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">全校开课查询</a></dd>
                        <dd><a href="javascript:;">查看校历</a></dd>
                        <dd><a href="">站内消息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;">click menu item</a></li>
                <li class="layui-nav-item"><a id="info" href="infoManage.jsp">消息管理</a></li>
                <li class="layui-nav-item"><a id="file" href="file.jsp">档案管理</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div style="padding: 0px;" id="divbody">
            <iframe id="f1" src="" width="100%" height="800px"></iframe>
        </div>
    </div>

<%--    <div class="layui-footer">--%>
<%--        <!-- 底部固定区域 -->--%>
<%--        底部固定区域--%>
<%--    </div>--%>
</div>
<script src="./layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });

    });
</script>
</body>
</html>
