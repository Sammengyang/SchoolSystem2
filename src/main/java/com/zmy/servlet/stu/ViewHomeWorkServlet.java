package com.zmy.servlet.stu; /**
 * @Description
 * @version
 * @author Sam  Email:superdouble@yeah.net
 * @create 2022-03-17 11:49
 */

import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.pojo.student.Student;
import com.zmy.pojotrait.student.HomeWork;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ViewHomeWorkServlet")
public class ViewHomeWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ViewHomeWorkServlet");
        String sid = (String) request.getSession().getAttribute("id");
        StuDaoImpl stuDao = new StuDaoImpl();
        Integer cid = stuDao.getCid(Integer.parseInt(sid));
        if (cid!=0){ // 找到该生的课程
            List<HomeWork> stuHomeWork = stuDao.getStuHomeWork(cid);
            request.getSession().setAttribute("stuHomeWork",stuHomeWork);
            response.sendRedirect("../../view/CheckWork.jsp");
        }else {
            // 跳到信息页面，修改信息
            response.sendRedirect("../../view/student/Info.jsp");
        }
    }
}
