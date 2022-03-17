package com.zmy.servlet.Teacher; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-16 22:59
 */

import com.zmy.dao.impl.TeacherDaoImpl;
import com.zmy.pojo.teacher.Teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/TeacherInifServlet")
public class TeacherInifServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt((String) request.getSession().getAttribute("id")) ;
        String tname = request.getParameter("tname");
        String pwd = request.getParameter("pwd");
        String tel = request.getParameter("tel");
        if (id == null) {
            response.sendRedirect("../../view/SignUp/Sign_up.jsp");
        } else {
            // 根据id查询数据库   查询教师信息
            TeacherDaoImpl teacherDao = new TeacherDaoImpl();
            Teacher teacher = new Teacher(tname,pwd,tel);
            boolean b = teacherDao.UpdateTeacherInfo(id,teacher);
            // 修改成功
            if (b) {
                teacher = teacherDao.getMyInfo(id);
                request.getSession().setAttribute("teacher",teacher);
                response.sendRedirect("../../view/student/Info.jsp");
            } else {
                request.getSession().setAttribute("msg","没查到该学生信息");
            }
        }

    }
}
