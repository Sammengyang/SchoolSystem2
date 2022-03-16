package com.zmy.servlet.stu; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-16 20:19
 */

import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.pojo.student.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ChangeInfoServlet")
public class ChangeInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Integer id = Integer.parseInt((String) request.getSession().getAttribute("id"));
        System.out.println(request.getParameter("sex"));
        System.out.println(request.getParameter("major"));
        Student student = new Student(
                request.getParameter("sname"),
                request.getParameter("pwd"),
                request.getParameter("sex"),
                request.getParameter("bir"),
                request.getParameter("insc"),
                request.getParameter("major"),
                request.getParameter("cid"),
                request.getParameter("tel")
                );
        StuDaoImpl stuDao = new StuDaoImpl();
        boolean b = stuDao.UpdateStudentInfo(id, student);
        if (b){
            // 查询用户信息
            Student stu = stuDao.getStuByid(id);
            request.getSession().setAttribute("user",stu);
            response.sendRedirect("../../view/student/Info.jsp");
        }


    }
}
