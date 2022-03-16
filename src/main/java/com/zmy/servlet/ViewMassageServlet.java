package com.zmy.servlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-16 14:11
 */

import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.dao.impl.TeacherDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/ViewMassageServlet")
public class ViewMassageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer mid = Integer.parseInt(request.getParameter("id"));
        String role = (String) request.getSession().getAttribute("role");
        String state = (String) request.getParameter("state");
        System.out.println(state);
        System.out.println(role);
        System.out.println(mid);
    }
}
