package com.zmy.dao.impl;

import com.zmy.dao.SignInDao;
import com.zmy.pojo.Student;
import com.zmy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-12 11:05
 */
public class SignInDaoImpl implements SignInDao {
    /**
     * 根据role判断查询的表，根据id来查询表内数据是否存在
     *
     * @param sid
     * @return
     */
    @Override
    public Student findByRoleAndid(Integer sid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from student where sid=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,sid);
            rs = ps.executeQuery();
            if (rs.next()){
                Student student = new Student();
                student.setSid(rs.getInt("sid"));
                student.setPwd(rs.getString("pwd"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return null;
    }

    /**
     *  注册成功将该学生加入数据库
     * @param student
     */
    @Override
    public void AddStudent(Student student) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "insert into student (sid,sname,pwd,tel)values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setObject(1,student.getSid());
            ps.setObject(2,student.getSname());
            ps.setObject(3,student.getPwd());
            ps.setObject(4,student.getTel());
            // 关闭资源
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }

    }
}
