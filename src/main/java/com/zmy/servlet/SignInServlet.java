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
        System.out.println("注册dopost。。。。");
        // 先检查该账号是否存在学校系统中
        Student student = new Student(
                Integer.parseInt(req.getParameter("sid")),
                req.getParameter("name"),
                req.getParameter("pwd"),
                req.getParameter("tel"),
                req.getParameter("role")
        );
        System.out.println("=========== jdbc 从数据库中查询数据书否存在 ============");
        // 根据身份确认查询得表，根据sid查询是否存在
        SignInDaoImpl signInDao = new SignInDaoImpl();
        Student stu = signInDao.findByRoleAndid(student.getSid());
        if (student!=null){
            if (student.getSid()!=null&&student.getPwd()==null){
                // 设置返回值类型
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.write("success");
                out.flush();
                out.close();
            }
        }else {
            // 该学生不在学校系统
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.write("false");
            out.flush();
            out.close();
        }
        if (stu!=null){
            if (student.getSid()!=null&&student.getPwd()==null){// 判断该学生是否注册过
                signInDao.AddStudent(student);
                resp.sendRedirect("../../view/SignUp/Sign_up.jsp");
            }
        }
    }
}
