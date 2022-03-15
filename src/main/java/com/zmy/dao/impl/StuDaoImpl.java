package com.zmy.dao.impl;


import com.zmy.dao.StuDao;
import com.zmy.pojo.student.StuLeave;
import com.zmy.pojo.student.Student;
import com.zmy.pojotrait.Stu_score;
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
     * @param sid  学号
     * @param pwd  密码
     * @param role 角色
     * @return 如果查询到返回student对象，否则返回null
     */
    @Override
    public Student findStudentBySignUP(Integer sid, String pwd, String role) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + role + " where sid=? and pwd=?";
        try {
            con = DBUtil.getCon();
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            // 填充占位符
            ps.setObject(1, sid);
            ps.setObject(2, pwd);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student(
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
            DBUtil.closeAll(con, ps, rs);
        }
        return null;
    }

    /**
     * @param sid
     * @param pwd
     * @param role
     */
    @Override
    public void UpdateStudentInfo(String sid, String pwd, String role) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into" + role + "values(?,?)";
    }

    /**
     * 根据id查询学生信息
     *
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
            ps.setObject(1, id);
            // 执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student(
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
            DBUtil.closeAll(con, ps, rs);
        }
        return null;
    }

    /**
     * 根据id或去对应人的历史成绩
     *
     * @param id
     * @return
     */
    @Override
    public List<Stu_score> getScoreBysid(Integer id) {
        List<Stu_score> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取链接
            con = DBUtil.getCon();
            String sql = "select sc.id, s.sid,sname,major,cname,credit,score,exam_time\n" +
                    "from student s,course c,scores sc \n" +
                    "WHERE s.sid=? AND sc.sid=s.sid and sc.cid=c.cid ";
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            // 执行sql语句
            rs = ps.executeQuery();
            while (rs.next()) {
                Stu_score scores = new Stu_score(
                        rs.getInt("id"),
                        rs.getInt("sid"),
                        rs.getString("major"),
                        rs.getString("cname"),
                        rs.getString("credit"),
                        rs.getString("score"),
                        rs.getDate("exam_time")

                );
                list.add(scores);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return null;
    }

    /**
     * 分页查询学生历史成绩
     *
     * @param id       学生id
     * @param page     页数
     * @param pageSize 页面展示数据数
     * @return
     */
    @Override
    public List<Stu_score> getScoreBysid(Integer id, Integer page, Integer pageSize) {
        Integer start = (page - 1) * pageSize;
        List<Stu_score> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select sc.id, s.sid,sname,major,cname,credit,score,exam_time\n" +
                    "from student s,course c,scores sc \n" +
                    "WHERE s.sid=? AND sc.sid=s.sid and sc.cid=c.cid limit ?,?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            ps.setObject(2, start);
            ps.setObject(3, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Stu_score scores = new Stu_score(
                        rs.getInt("id"),
                        rs.getInt("sid"),
                        rs.getString("major"),
                        rs.getString("cname"),
                        rs.getString("credit"),
                        rs.getString("score"),
                        rs.getDate("exam_time")

                );
                list.add(scores);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return list;
    }

    /**
     * 根据id获取学生成绩最大页数
     *
     * @param id 学号
     * @return
     */
    @Override
    public Integer getMaxPage(Integer id, Integer pageSize) {
        Integer MaxPageSize = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select count(s.sid) from student s,course c,scores sc \n" +
                    "WHERE s.sid=? AND sc.sid=s.sid and sc.cid=c.cid ";
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
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

    @Override
    public void applyHoliday(StuLeave stuLeave) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "insert into written (sid,tid,text,startTime,endTime,state) values (?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setObject(1, stuLeave.getSid());
            ps.setObject(2, stuLeave.getTid());
            ps.setObject(3, stuLeave.getText());
            ps.setObject(4, stuLeave.getStartTime());
            ps.setObject(5, stuLeave.getEndTime());
            ps.setObject(6, stuLeave.getState());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps);
        }
    }

    @Override
    public List<StuLeave> getHistoryHoliday(Integer id) {
        List<StuLeave> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "SELECT sw.sid,sw.sname,sw.tid,t.tname,text,startTime,endTime,state  FROM teacher t,(\n" +
                    "\tSELECT w.sid,stu.sname,w.tid,text,startTime,endTime,state  FROM\n" +
                    "student stu,written w\n" +
                    "where stu.sid=w.sid AND w.sid=?\n" +
                    ") sw WHERE t.tid = sw.tid";
            ps = con.prepareStatement(sql);
            ps.setObject(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                StuLeave stuLeave = new StuLeave(
                        rs.getInt("sid"),
                        rs.getString("sname"),
                        rs.getInt("tid"),
                        rs.getString("tname"),
                        rs.getString("text"),
                        rs.getString("startTime"),
                        rs.getString("endTime"),
                        rs.getString("state")
                );
                list.add(stuLeave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return list;
    }
}
