package com.zmy.dao.impl;

import com.zmy.dao.TeacherDao;
import com.zmy.pojo.teacher.ScoreVO;
import com.zmy.pojo.teacher.Teacher;
import com.zmy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-14 14:40
 */
public class TeacherDaoImpl implements TeacherDao {
    /**
     * 根据role和账号，密码判断是否登录成功
     *
     * @param tid      编号
     * @param password 密码
     * @param role     角色
     * @return
     */
    @Override
    public Teacher GetTeacherBytid(Integer tid, String password, String role) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + role + " where sid=? and pwd=?";
        try {
            con = DBUtil.getCon();
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            // 填充占位符
            ps.setObject(1, tid);
            ps.setObject(2, password);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
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
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return null;
    }

    /**
     * 教师查询自己学生的成绩
     *
     * @return list 返回学生成绩集合
     */
    @Override
    public List<ScoreVO> getAllStuScore() {
        List<ScoreVO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select s.sid,sname,major,cname,credit,score,exam_time\n" +
                    "from student s,course c,scores sc\n" +
                    "WHERE sc.sid=s.sid and sc.cid=c.cid";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ScoreVO scoreVO = new ScoreVO(rs.getInt("sid"),
                        rs.getString("sname"),
                        rs.getString("major"),
                        rs.getString("cname"),
                        rs.getString("credit"),
                        rs.getString("score"),
                        rs.getString("exam_time"));
                list.add(scoreVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return list;
    }

    /**
     * 分页查询学生成绩
     *
     * @param page     页数
     * @param pageSize 页面展现条数
     * @return
     */
    @Override
    public List<ScoreVO> getAllStuScore(Integer page, Integer pageSize) {
        Integer start = (page - 1) * pageSize;
        List<ScoreVO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select s.sid,sname,major,cname,credit,score,exam_time\n" +
                    "from student s,course c,scores sc\n" +
                    "WHERE sc.sid=s.sid and sc.cid=c.cid limit ?,?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, start);
            ps.setObject(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                ScoreVO scoreVO = new ScoreVO(rs.getInt("sid"),
                        rs.getString("sname"),
                        rs.getString("major"),
                        rs.getString("cname"),
                        rs.getString("credit"),
                        rs.getString("score"),
                        rs.getString("exam_time"));
                list.add(scoreVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return list;
    }

    /**
     * 获取总页数
     *
     * @param pageSize 每页的数据数
     * @return
     */
    @Override
    public Integer getMaxPageSize(Integer pageSize) {
        Integer MaxPageSize = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select count(s.sid)" +
                    "from student s,course c,scores sc\n" +
                    "WHERE sc.sid=s.sid and sc.cid=c.cid";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                MaxPageSize = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        double count = MaxPageSize / pageSize * 1.0;
        return (int) Math.ceil(count);
    }
}
