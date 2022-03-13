package com.zmy.servlet.SendSms;



import com.zmy.util.sensms.SendSmsUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-12 22:29
 */
@WebServlet("/SendSmsServlet")
public class SendSmsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 发送短信
//        String code = SendSmsUtil.SendSms();
        String code = "123456";
        // 获取到手机号
        String tel = req.getParameter("username");
        if (code!=null&&tel.length()==11){
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.write("success");
            out.flush();
            out.close();
        }else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.write("false");
            out.flush();
            out.close();
        }
        req.getSession().setAttribute("code",code);
        req.getSession().setAttribute("tel",tel);
        req.getRequestDispatcher("../../view/SignIn/SignIn.jsp").forward(req,resp);
    }
}
