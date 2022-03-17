package com.zmy.servlet.stu; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-15 19:29
 */

import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.pojotrait.student.StuLeave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/StuLeaveServlet")
public class StuLeaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表中数据
        StuLeave stuLeave = new StuLeave();
        stuLeave.setSid(Integer.parseInt(request.getParameter("sid")));
        stuLeave.setSname(request.getParameter("sname"));
        stuLeave.setTid(Integer.parseInt(request.getParameter("tid")));
        stuLeave.setText(request.getParameter("texts"));
        stuLeave.setState(request.getParameter("startTime"));
        stuLeave.setEndTime(request.getParameter("endtime"));
        request.getSession().setAttribute("stuLeave",stuLeave);
        StuDaoImpl stuDao = new StuDaoImpl();
        stuDao.applyHoliday(stuLeave);
        response.sendRedirect("/StuHistoryHolidayServlet");
    }
}
