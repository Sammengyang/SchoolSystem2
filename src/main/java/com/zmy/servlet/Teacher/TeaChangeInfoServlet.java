package com.zmy.servlet.Teacher; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-17 0:08
 */

import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.dao.impl.TeacherDaoImpl;
import com.zmy.pojo.student.Student;
import com.zmy.pojo.teacher.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TeaChangeInfoServlet", value = "/TeaChangeInfoServlet")
public class TeaChangeInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");  // todo 教师改变个人信息
        Integer id = Integer.parseInt((String) request.getSession().getAttribute("id"));
        Teacher teacher1 = new Teacher(
                request.getParameter("tname"),
                request.getParameter("pwd"),
                request.getParameter("tel")
        );
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        boolean b = teacherDao.UpdateTeacherInfo(id, teacher1);
        if (b){
            // 查询用户信息
            Teacher teacher = teacherDao.getMyInfo(id);
            request.getSession().setAttribute("teacher",teacher);
            response.sendRedirect("../../view/student/Info.jsp");
        }
    }
}
