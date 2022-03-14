package com.zmy.dao.impl;

import com.zmy.dao.TeacherDao;
import com.zmy.pojo.Student;
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
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from "+role+" where sid=? and pwd=?";
        try {
            con = DBUtil.getCon();
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            // 填充占位符
            ps.setObject(1,tid);
            ps.setObject(2,password);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()){
                Teacher teacher = new Teacher(
                        rs.getInt("tid"),
                        rs.getString("tname"),
                        rs.getString("pwd"),
                        rs.getString("role"),
                        rs.getDate("inschool_time"),
                        rs.getString("tel")
                );
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return null;
    }
}
