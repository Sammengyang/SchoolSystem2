package com.zmy.servlet.stu;

import com.zmy.dao.impl.SignInDaoImpl;
import com.zmy.pojo.Student;
import com.zmy.util.DBUtil;

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
 * @create 2022-03-12 18:51
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        // 获取到输入的账号
        Integer sid = Integer.parseInt(username);
        // 根据输入的账号判断是否找到学生
        SignInDaoImpl signInDao = new SignInDaoImpl();
        Student student = signInDao.findByRoleAndid(sid);
        if (student.getSid()!=null && student.getPwd()!=null){
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.write("success");
            out.flush();
            out.close();
        }else{
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.write("false");
            out.flush();
            out.close();
        }

    }
}
