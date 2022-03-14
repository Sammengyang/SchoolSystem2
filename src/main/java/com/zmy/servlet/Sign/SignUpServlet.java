package com.zmy.servlet.Sign;

import com.zmy.dao.impl.SignUpDaoImpl;
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
        String id = req.getParameter("sid");
        int iid = Integer.parseInt(id);
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        // 根据username 和 password 查询学生
        SignUpDaoImpl signUpDao = new SignUpDaoImpl();
        boolean bySignUP = signUpDao.findBySignUP(iid, password, role);
        if (bySignUP){ // 登录成功
            req.getSession().setAttribute("role",role);
            // 将登录人的sid存入session
            req.getSession().setAttribute("id",id);
            resp.sendRedirect("../../view/student/stu_home.jsp");
        }else{
            // 将登录人的sid存入session
            req.getSession().setAttribute("id",id);
            resp.sendRedirect("../../view/SignUp/Sign_up.jsp");
        }
    }
}
