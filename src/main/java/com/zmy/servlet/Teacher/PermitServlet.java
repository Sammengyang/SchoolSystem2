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
        // 获取请假人id
        Integer sid = Integer.parseInt(request.getParameter("sid"));
        // 获取登录人id
        Integer tid = Integer.parseInt((String) request.getSession().getAttribute("id"));
        String startTime = request.getParameter("startTime");
        String state = request.getParameter("state");
        System.out.println(sid);
        System.out.println(tid);
        System.out.println(startTime);
        System.out.println(state);
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        boolean b = teacherDao.permitLeave(sid, state, startTime);
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
