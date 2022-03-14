<%@ page import="com.zmy.servlet.stu.ScoreServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.zmy.pojotrait.Stu_score" %>
<%@ page import="com.zmy.pojo.Scores" %><%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/3/10
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>历史成绩</title>
    <script src="js/jquery-3.6.0.js" type="text/javascript"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
    <%
        List<Scores> scores = (List) session.getAttribute("scores");
    %>
<body>
    <table class="table table-hover">
        <thead>
            <tr>
                <td>考号</td>
                <td>学号</td>
                <td>班级</td>
                <td>分数</td>
                <td>考试时间</td>
            </tr>
        </thead>
        <tbody>
<%--        <c:forEach items="${list}" var="el">--%>
<%--            <tr>--%>
<%--                <td>${el.getId()}</td>--%>
<%--                <td>${el.getSid()}</td>--%>
<%--                <td>${el.getCid()}</td>--%>
<%--                <td>${el.getScore()}</td>--%>
<%--                <td>${el.getExam_time()}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
        <%
            if (scores.size()>0){
                for (int i = 0; i < scores.size(); i++) {
                    Scores score = scores.get(i);
        %>
            <tr>
                <td><%=score.getId()%></td>
                <td><%=score.getSid()%></td>
                <td><%=score.getCid()%></td>
                <td><%=score.getScore()%></td>
                <td><%=score.getExam_time()%></td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</body>
</html>
