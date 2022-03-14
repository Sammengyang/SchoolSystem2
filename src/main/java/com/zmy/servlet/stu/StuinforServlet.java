package com.zmy.servlet.stu;

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
 * @create 2022-03-14 15:56
 */
@WebServlet("/StuinforServlet")
public class StuinforServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = (Integer) req.getSession().getAttribute("id");
        if (id == null) {
            resp.sendRedirect("../../view/SignUp/Sign_up.jsp");
        } else {
            // 根据id查询数据库   查询学生信息
            StuDaoImpl stuDao = new StuDaoImpl();
            Student stuInfo = stuDao.getStuByid(id);
            if (stuInfo == null) {
                req.getSession().setAttribute("msg","没查到该学生信息");
            } else {
                req.getSession().setAttribute("stuinfo",stuInfo);
                resp.sendRedirect("../../view/student/stu_infor.jsp");
            }
        }
    }
}
