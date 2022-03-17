package com.zmy.servlet.Teacher; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-15 22:54
 */

import com.zmy.dao.impl.TeacherDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/PermitServlet")
public class PermitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请假人id
        Integer sid = Integer.parseInt(request.getParameter("sid"));
        // 获取登录人id
        Integer tid = Integer.parseInt((String) request.getSession().getAttribute("id"));
        String startTime = request.getParameter("startTime");
        String state = request.getParameter("state");
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        boolean b = teacherDao.permitLeave(sid, state, startTime);
        if (b){
            request.getRequestDispatcher("/leave_for_approvalServlet").forward(request,response);
        }else {
            // 跳转servlet。.
            request.getRequestDispatcher("/leave_for_approvalServlet").forward(request,response);
        }
    }
}
