package com.zmy.dao.impl;

import com.zmy.dao.SignUpDao;
import com.zmy.pojo.Student;
import com.zmy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-14 15:13
 */
public class SignUpDaoImpl implements SignUpDao {

    /**
     * 根据 role判断查询的表，账号和密码判断是否登录成功
     * @param id 账号
     * @param pwd 密码
     * @param role
     * @return
     */
    @Override
    public boolean findBySignUP(Integer id, String pwd, String role) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        if ("student".equals(role)){
            sql = "select * from "+role+" where sid=? and pwd=?";
        }
        if ("teacher".equals(role)){
            sql = "select * from "+role+" where tid=? and pwd=?";
        }
        try {
            con = DBUtil.getCon();
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            // 填充占位符
            ps.setObject(1,id);
            ps.setObject(2,pwd);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return false;
    }
}
