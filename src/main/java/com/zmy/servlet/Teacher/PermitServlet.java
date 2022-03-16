package com.zmy.servlet.Teacher; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-15 22:54
 */

import com.zmy.dao.impl.TeacherDaoImpl;
import com.zmy.pojo.student.StuLeave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.dgc.Lease;
import java.util.List;

@WebServlet("/PermitServlet")
public class PermitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PermitServlet......");
//        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer id = 1001;
        String startTime = request.getParameter("startTime");
//        String state = request.getParameter("state");
        String state = "已批准";
        System.out.println(id);
        System.out.println(startTime);
        System.out.println(state);
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        boolean b = teacherDao.permitLeave(id, state, startTime);
        if (b){
            System.out.println("成功");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("success");
            out.flush();
            out.close();
        }else {
            System.out.println("失败");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("false");
            out.flush();
            out.close();
        }
    }
}
