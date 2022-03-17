package com.zmy.servlet.Teacher; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-17 16:07
 */

import com.zmy.dao.impl.TeacherDaoImpl;
import com.zmy.pojotrait.student.HomeWork;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/CheckWorkServlet")
public class CheckWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CheckWorkServlet");
        // 获取到登录人id
        String id = (String) request.getSession().getAttribute("id");
        String role = (String) request.getSession().getAttribute("role");
        if ("teacher".equals(role)){
            TeacherDaoImpl teacherDao = new TeacherDaoImpl();
            List<HomeWork> homeWorkList = teacherDao.getHomeWork(Integer.parseInt(id));
            request.getSession().setAttribute("homeWorkList", homeWorkList);
            response.sendRedirect("../../view/CheckWork.jsp");
        }


    }
}
