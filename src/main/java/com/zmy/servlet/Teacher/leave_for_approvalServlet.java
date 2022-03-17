package com.zmy.servlet.Teacher; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-15 22:11
 */

import com.zmy.dao.impl.TeacherDaoImpl;
import com.zmy.pojotrait.student.StuLeave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( "/leave_for_approvalServlet")
public class leave_for_approvalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("leave_for_approvalServlet");
        String id = (String) request.getSession().getAttribute("id");
        Integer tid = Integer.parseInt(id);
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        List<StuLeave> leaveList = teacherDao.leave_for_approvalServlet(tid);
        request.getSession().setAttribute("leaveList",leaveList);
        response.sendRedirect("../../view/teacher/leave_for_approval.jsp");
    }
}
