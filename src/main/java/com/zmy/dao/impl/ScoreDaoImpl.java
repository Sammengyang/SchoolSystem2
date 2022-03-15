package com.zmy.dao.impl;

import com.zmy.dao.ScoreDao;
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
 * @create 2022-03-13 13:59
 */
public class ScoreDaoImpl implements ScoreDao {
    /**
     *  根据sid查询学生的历史成绩
     * @param sid
     * @return
     */
    @Override
    public List<Stu_score> getScoreBysid(Integer sid) {
        List<Stu_score> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 获取链接
            con = DBUtil.getCon();
            String sql = "select * from scores where sid=?";
            // 预编译sql语句
            ps = con.prepareStatement(sql);
            // 执行sql语句
            ps.setObject(1,sid);
            // 获取结果集
            rs = ps.executeQuery();
            while (rs.next()){
                Stu_score stuScore = new Stu_score(
                        rs.getInt("id"),
                        rs.getInt("sid"),
                        rs.getString("major"),
                        rs.getString("cname"),
                        rs.getString("credit"),
                        rs.getString("score"),
                        rs.getDate("exam_time")
                );
                list.add(stuScore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return list;
    }

    /**
     * 根据id查询对应学生成绩，并根据页数进行分页
     * @param sid
     * @param num
     * @return
     */
    @Override
    public List<Stu_score> getPagingScore(Integer sid, Integer num) {
        List<Stu_score> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getCon();
            String sql = "select * from scores where sid=? limit "+2+",2";
            ps = con.prepareStatement(sql);
            ps.setObject(1, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Stu_score stuScore = new Stu_score(
                        rs.getInt("id"),
                        rs.getInt("sid"),
                        rs.getString("major"),
                        rs.getString("cname"),
                        rs.getString("credit"),
                        rs.getString("score"),
                        rs.getDate("exam_time")
                );
                list.add(stuScore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return null;
    }
}
