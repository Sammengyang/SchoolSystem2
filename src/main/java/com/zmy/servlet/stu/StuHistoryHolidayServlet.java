package com.zmy.servlet.stu; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-15 21:04
 */

import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.pojo.student.StuLeave;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/StuHistoryHolidayServlet")
public class StuHistoryHolidayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("id");
        Integer sid = Integer.parseInt(id);
        StuDaoImpl stuDao = new StuDaoImpl();
        List<StuLeave> historyHoliday = stuDao.getHistoryHoliday(sid);
        request.getSession().setAttribute("historyHoliday",historyHoliday);
        response.sendRedirect("../../view/student/History_holiday.jsp");
    }
}
