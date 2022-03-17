package com.zmy.servlet.stu; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-17 20:34
 */

import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.pojo.student.Student;
import com.zmy.pojotrait.student.HomeWork;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet("/SubmitWorkServlet")
public class SubmitWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提交人id
        Integer id = Integer.parseInt((String) request.getSession().getAttribute("id"));
        // 提交时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String submitTime = sf.format(new Date());
        String jobcontent = request.getParameter("mywork");

        StuDaoImpl stuDao = new StuDaoImpl();
        stuDao.submitWork(new HomeWork(id,submitTime,jobcontent));
        // 跳转到查看作业页面
        request.getRequestDispatcher("/ViewHomeWorkServlet").forward(request,response);
    }
}
