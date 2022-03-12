package com.zmy.servlet;


import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-11 21:23
 */
@WebServlet("/StuServlet")
public class StuServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost.....");
        String username = req.getParameter("username");
        int sid = Integer.parseInt(username);
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        System.out.println(username);
        // 根据username 和 password 查询学生
        StuDaoImpl stuDao = new StuDaoImpl();
        Student student = stuDao.findStudentBySignUP(sid, password,role);
        req.getSession().setAttribute("student",student);
        if (student!=null){ // 登录成功，跳转到主页面
            resp.sendRedirect("../../view/student/stu_home.jsp");
        }else{ // 登录失败，跳转到登录页面，并且保存账号
            Cookie cookie = new Cookie("username",username);
            resp.sendRedirect("../../view/SignUp/Sign_up.jsp");
        }
    }
}
