package com.zmy.servlet.stu;

import com.zmy.dao.impl.ScoreDaoImpl;
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
        System.out.println("score doget....");
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("score dopost....");
        // 获取到
        String username = req.getParameter("username");
        Integer sid = Integer.parseInt(username);
        ScoreDaoImpl scoreDao = new ScoreDaoImpl();
        // 获取到历史分数记录
        List<Stu_score> scoreBysid = scoreDao.getScoreBysid(sid);
        // 将数据放入session域中
        req.getSession().setAttribute("list",scoreBysid);
        // 请求转发到stu_score页面
        req.getRequestDispatcher("../../view/student/stu_score.jsp").forward(req,resp);
    }
}
