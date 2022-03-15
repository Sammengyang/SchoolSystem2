package com.zmy.servlet.Sign;

import com.zmy.dao.impl.SignUpDaoImpl;
import com.zmy.pojo.student.Student;
import com.zmy.pojo.teacher.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-14 15:08
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("student");
        req.getSession().removeAttribute("teacher");
        String id = req.getParameter("sid");
        int iid = Integer.parseInt(id);
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if (null==role){ // 未选择角色
            resp.sendRedirect("../../view/SignUp/Sign_up.jsp");
        }else if ("student".equals(role)){  // 判定是学生
            // 根据username 和 password 查询学生
            SignUpDaoImpl signUpDao = new SignUpDaoImpl();
            Student student = signUpDao.GetStudentByid(iid, password, role);
            if (student!=null){ // 登录成功
                req.getSession().setAttribute("role",role);
                // 将登录人的sid存入session
                req.getSession().setAttribute("id",id);
                // 将信息存入 session
                req.getSession().setAttribute("user",student);
                resp.sendRedirect("../../view/student/home.jsp");
            }else{
                // 将登录人的sid存入session
                req.getSession().setAttribute("id",id);
                resp.sendRedirect("../../view/SignUp/Sign_up.jsp");
            }
        }else if ("teacher".equals(role)){
            SignUpDaoImpl signUpDao = new SignUpDaoImpl();
            Teacher teacher = signUpDao.GetTeacherBytid(iid, password, role);
            req.getSession().setAttribute("role",role);
            // 将登录人的sid存入session
            req.getSession().setAttribute("id",id);
            // 将信息存入 session
            req.getSession().setAttribute("user",teacher);
            resp.sendRedirect("../../view/student/home.jsp");
        }
    }
}
