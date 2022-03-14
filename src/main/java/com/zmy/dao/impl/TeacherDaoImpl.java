package com.zmy.dao.impl;

import com.zmy.dao.TeacherDao;
import com.zmy.pojo.Teacher;
import com.zmy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-14 14:40
 */
public class TeacherDaoImpl implements TeacherDao {
    /**
     * 根据role和账号，密码判断是否登录成功
     * @param tid 编号
     * @param password 密码
     * @param role 角色
     * @return
     */
    @Override
    public Teacher GetTeacherBytid(Integer tid, String password, String role) {
        Teacher teacher = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from "+role+"where tid=? and pwd=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,tid);
            ps.setObject(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                teacher = new Teacher();
                teacher.setTid(rs.getInt("tid"));
                teacher.setPwd(rs.getString("pwd"));
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return teacher;
    }
}
