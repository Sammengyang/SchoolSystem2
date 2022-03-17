package com.zmy.servlet; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-16 11:07
 */

import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.dao.impl.TeacherDaoImpl;
import com.zmy.pojotrait.student.Massage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetMassageServlet")
public class GetMassageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        if ("student".equals(role)){
            StuDaoImpl stuDao = new StuDaoImpl();
            List<Massage> massage = stuDao.getMassage(role);
            request.getSession().setAttribute("massage",massage);
            response.sendRedirect("../../view/Massage.jsp");
        }
        if ("teacher".equals(role)){
            TeacherDaoImpl teacherDao = new TeacherDaoImpl();
            List<Massage> massage = teacherDao.getMassage(role);
            request.getSession().setAttribute("massage",massage);
            response.sendRedirect("../../view/Massage.jsp");
        }
    }
}
