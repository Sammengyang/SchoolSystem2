package com.zmy.servlet.Teacher; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-15 10:21
 */

import com.zmy.dao.impl.TeacherDaoImpl;
import com.zmy.pojo.teacher.ScoreVO;

import  javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/QueryAllScoreServlet")
public class QueryAllScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        String pageNum = request.getParameter("pageNum");
        Integer pageSize = 3;
        // 刚开始访问的时候，无法获取到pageNum 因此判断是否是第一次访问
        if (pageNum==null||"".equals(pageNum)){ // todo 用正则表达式来处理非法字符
            pageNum="1";
        }
        // 处理页面越接问题
        if (Integer.parseInt(pageNum)<1){
            pageNum="1";
        }
        // 计算出一共有多少页，计算出最大页数
        Integer maxPageSize = teacherDao.getMaxPageSize(pageSize);
        request.getSession().setAttribute("maxPageSize",maxPageSize);
        if (Integer.parseInt(pageNum)>maxPageSize){
            pageNum=String.valueOf(maxPageSize);
        }
        String role = (String) request.getSession().getAttribute("role");
        if ("teacher".equals(role)){ // 判断登录的是教师，查询成绩
            // 教师获取到所有成绩
            List<ScoreVO> allStuScore = teacherDao.getAllStuScore(Integer.parseInt(pageNum),pageSize);
            request.getSession().setAttribute("pageNum",Integer.parseInt(pageNum));
            request.getSession().setAttribute("list",allStuScore);
            // 获取后跳转页面
            response.sendRedirect("../../view/teacher/getAllStuScore.jsp");
        }else{ //不是教师
            request.getSession().setAttribute("msg","权限不足，请重新登录！");
            response.sendRedirect("../../view/SignUp/Sign_up.jsp");
        }
    }
}
