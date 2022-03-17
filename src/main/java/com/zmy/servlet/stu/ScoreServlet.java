package com.zmy.servlet.stu;

import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.pojotrait.student.Stu_score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-12 16:29
 */
@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StuDaoImpl stuDao = new StuDaoImpl();
        Integer id = Integer.parseInt((String) req.getSession().getAttribute("id"));
        String role = (String) req.getSession().getAttribute("role");
        System.out.println(role);
        System.out.println(id);
        if (id == null && "student".equals(role)) {
            resp.sendRedirect("../../view/SignUp/Sign_up.jsp");
        } else {
            String pageNum = req.getParameter("pageNum");
            Integer pageSize = 3;
            // 第一此访问的时候 pageNum没有赋值  , 处理访问越接问题
            if (pageNum == null || "".equals(pageNum) || Integer.parseInt(pageNum) <1) {
                pageNum = "1";
            }
            // 得出成绩一共有多少页
            Integer maxPageSize = stuDao.getMaxPage(id, pageSize);
            req.getSession().setAttribute("maxPageSize",maxPageSize);
            // 处理越接问题
            if (Integer.parseInt(pageNum)>maxPageSize){
                pageNum=String.valueOf(maxPageSize);
            }
            // 根据id查询数据库   查询学生成绩
            List<Stu_score> scores = stuDao.getScoreBysid(id,Integer.parseInt(pageNum),pageSize);
            req.getSession().setAttribute("pageNum",Integer.parseInt(pageNum));
            req.getSession().setAttribute("list",scores);
            if (scores == null) {
                req.getSession().setAttribute("msg", "没查到该学生成绩");
            } else {
                req.getSession().setAttribute("scores", scores);
                resp.sendRedirect("../../view/student/stu_score.jsp");
            }
        }
    }
}
