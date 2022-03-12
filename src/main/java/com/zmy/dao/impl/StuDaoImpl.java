package com.zmy.dao.impl;


import com.zmy.dao.StuDao;
import com.zmy.pojo.Student;
import com.zmy.util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @Override
    public void UpdateStudentInfo(String sid, String pwd, String role) {
        Connection con=null;
        PreparedStatement ps = null;
        String sql = "insert into"+role+"values(?,?)";
    }


}
