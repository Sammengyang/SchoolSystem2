package com.zmy.servlet.stu.scores;

import com.zmy.dao.impl.ScoreDaoImpl;
import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.pojo.Scores;
import com.zmy.pojotrait.Stu_score;

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
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt((String) req.getSession().getAttribute("id")) ;
        if (id == null) {
            resp.sendRedirect("../../view/SignUp/Sign_up.jsp");
        } else {
            // 根据id查询数据库   查询学生成绩
            StuDaoImpl stuDao = new StuDaoImpl();
            List<Scores> scores = stuDao.getScoreBysid(id);
            if (scores == null) {
                req.getSession().setAttribute("msg","没查到该学生成绩");
            } else {
                req.getSession().setAttribute("scores",scores);
                resp.sendRedirect("../../view/student/stu_score.jsp");
            }
        }
    }
}
