package com.zmy.dao.impl;

import com.zmy.dao.TeacherDao;
import com.zmy.pojo.student.Massage;
import com.zmy.pojo.student.StuLeave;
import com.zmy.pojo.student.Student;
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
    @Override
    public Teacher getMyInfo(Integer id) {
        Teacher teacher = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql ="select * from teacher where tid=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                teacher=new Teacher(
                        rs.getInt("tid"),
                        rs.getString("tname"),
                        rs.getString("pwd"),
                        rs.getString("role"),
                        rs.getDate("inschool_time"),
                        rs.getString("tel")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return teacher;
    }

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

    /**
     *  根的据登录人id 查看收到请假申请
     *
     * @param tid 教师id
     * @return 返回请假历史集合
     */
    @Override
    public List<StuLeave> leave_for_approvalServlet(Integer tid) {
        List<StuLeave> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            // 查询该老师收到的请假申请
            String sql = "SELECT sw.sid,sw.sname,sw.tid,t.tname,text,startTime,endTime,state  FROM teacher t,(\n" +
                    "SELECT w.sid,stu.sname,w.tid,text,startTime,endTime,state  FROM\n" +
                    "student stu,written w where stu.sid=w.sid \n" +
                    ") sw WHERE t.tid = sw.tid and t.tid =?";
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            ps.setObject(1,tid);
            rs = ps.executeQuery();
            while (rs.next()){
                StuLeave stuLeave = new StuLeave();
                stuLeave.setSid(rs.getInt("sid"));
                stuLeave.setSname(rs.getString("sname"));
                stuLeave.setText(rs.getString("text"));
                stuLeave.setStartTime(rs.getString("startTime"));
                stuLeave.setEndTime(rs.getString("endTime"));
                stuLeave.setState(rs.getString("state"));
                list.add(stuLeave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return list;
    }

    /**
     * 根据提交请假申请人的id和申请时间，对数据状态进行修改
     *
     * @param id    申请人id
     * @param state
     * @param startTime 离校时间
     * @return
     */
    @Override
    public boolean permitLeave(Integer id, String state,String startTime) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "update written set state=? where sid=? and startTime=?";
            ps = con.prepareStatement(sql);
            // 填充占位符，状态，id和请假时间
            ps.setObject(1,state);
            ps.setObject(2,id);
            ps.setObject(3,startTime);
            int i = ps.executeUpdate();
            if (i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return false;
    }

    /**
     * 根据权限展示能看到的消息
     *
     * @param role 登录人角色 role为1是教师和同学可共同查看的通知
     * @return
     */
    @Override
    public List<Massage> getMassage(String role) {
        List<Massage> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from massage where role=? or role=1";
            ps = con.prepareStatement(sql);
            ps.setObject(1,role);
            rs = ps.executeQuery();
            while (rs.next()){
                Massage massage = new Massage(
                        rs.getInt("id"),
                        rs.getString("pname"),
                        rs.getString("title"),
                        rs.getString("text"),
                        rs.getDate("postTime"),
                        rs.getString("role")
                );
                list.add(massage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return list;
    }

    /**
     *  根据id查看能看的通知
     *
     * @param id
     * @param state
     * @return
     */
    @Override
    public boolean viewMasage(Integer id,String state) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "update massage set state=? where id=?";
            ps = con.prepareStatement(sql);
            // 填充占位符，状态，id和请假时间
            ps.setObject(1,state);
            ps.setObject(2,id);
            int i = ps.executeUpdate();
            if (i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return false;
    }

    /**
     * 根据教师id，修改自己的信息
     *
     * @param id 教师id
     * @param teacher 存储要修改的信息
     * @return
     */
    @Override
    public boolean UpdateTeacherInfo(Integer id, Teacher teacher) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getCon();
            String sql = "update teacher set tname=?, pwd=?,role=?,inschool_time=?,tel=? where sid=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, teacher.getTname());
            ps.setObject(2,teacher.getPwd());
            ps.setObject(3,teacher.getRole());
            ps.setObject(4,teacher.getInschool_time());
            ps.setObject(5,teacher.getTel());
            ps.setObject(6,id);
            int i = ps.executeUpdate();
            if (i > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps);
        }
        return false;
    }
}
