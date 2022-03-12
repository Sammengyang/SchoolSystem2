package com.zmy.servlet;

import com.zmy.dao.impl.SignInDaoImpl;
import com.zmy.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-12 10:37
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget....");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到注册页面的数据，并存入student对象中
        Student stu;
        String id = req.getParameter("sid");
        String sname = req.getParameter("names");
        String password = req.getParameter("password");
        String tel = req.getParameter("tel");
        String role = req.getParameter("role");
        if(id.length()!=0&&sname!=null&&password.length()!=0&&tel.length()!=0&&role!=null){
            Integer sid = Integer.parseInt(id);
            stu = new Student(sid,sname,password, tel,role);
            SignInDaoImpl signInDao = new SignInDaoImpl();
            signInDao.AddStudent(stu);
            resp.sendRedirect("../../view/SignUp/Sign_up.jsp");
        } else{
            resp.sendRedirect("../../view/SignIn/SignIn.jsp");
        }
    }
}
