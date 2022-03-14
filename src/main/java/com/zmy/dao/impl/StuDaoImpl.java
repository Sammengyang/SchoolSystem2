package com.zmy.dao.impl;


import com.zmy.dao.StuDao;
import com.zmy.pojo.Scores;
import com.zmy.pojo.Student;
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
 * @create 2022-03-11 20:34
 */
public class StuDaoImpl implements StuDao {
    /**
     * 根据用户名和密码对student表进行查询，以role判断收索数据库得哪张表
     *
     * @param sid 学号
     * @param pwd 密码
     * @param role 角色
     * @return  如果查询到返回student对象，否则返回null
     */
    @Override
    public Student findStudentBySignUP(Integer sid, String pwd, String role) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from "+role+" where sid=? and pwd=?";
        try {
            con = DBUtil.getCon();
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            // 填充占位符
            ps.setObject(1,sid);
            ps.setObject(2,pwd);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()){
                Student student=new Student(
                        rs.getInt("sid"),
                        rs.getString("sname"),
                        rs.getString("gender"),
                        rs.getString("pwd"),
                        rs.getString("birthday"),
                        rs.getString("inschool_time"),
                        rs.getString("major"),
                        rs.getString("tel"),
                        rs.getString("role"),
                        rs.getString("cid")
                );
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return null;
    }
    /**
     *
     * @param sid
     * @param pwd
     * @param role
     */
    @Override
    public void UpdateStudentInfo(String sid, String pwd, String role) {
        Connection con=null;
        PreparedStatement ps = null;
        String sql = "insert into"+role+"values(?,?)";
    }

    /**
     * 根据id查询学生信息
     * @param id
     * @return
     */
    @Override
    public Student getStuByid(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取链接
            con = DBUtil.getCon();
            String sql = "select * from student where sid=?";
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            ps.setObject(1,id);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()){
                Student student=new Student(
                        rs.getInt("sid"),
                        rs.getString("sname"),
                        rs.getString("gender"),
                        rs.getString("pwd"),
                        rs.getString("birthday"),
                        rs.getString("inschool_time"),
                        rs.getString("major"),
                        rs.getString("tel"),
                        rs.getString("role"),
                        rs.getString("cid")
                );
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
     *  根据id或去对应人的历史成绩
     *
     * @param id
     * @return
     */
    @Override
    public List<Scores> getScoreBysid(Integer id) {
        List<Scores> list= new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取链接
            con = DBUtil.getCon();
            String sql = "select * from scores where sid=?";
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            ps.setObject(1,id);
            // 执行sql语句
            rs = ps.executeQuery();
            while (rs.next()){
                Scores scores = new Scores(
                        rs.getInt("id"),
                        rs.getInt("sid"),
                        rs.getString("cid"),
                        rs.getString("score"),
                        rs.getDate("exam_time")

                );
                list.add(scores);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return null;
    }


}
