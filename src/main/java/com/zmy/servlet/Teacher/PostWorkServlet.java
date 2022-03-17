package com.zmy.servlet.Teacher; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-17 14:55
 */

import com.zmy.dao.impl.TeacherDaoImpl;
import com.zmy.pojotrait.student.HomeWork;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/PostWorkServlet")
public class PostWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PostWorkServlet");
        Integer tid = Integer.parseInt((String) request.getSession().getAttribute("id"));
        Integer cid = Integer.parseInt(request.getParameter("cid"));
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String work = request.getParameter("work");
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.PostHomeWork(new HomeWork(tid,cid,work,startTime,endTime));
        // 跳转到检查作业servlet
        request.getRequestDispatcher("/CheckWorkServlet").forward(request,response);
    }
}
