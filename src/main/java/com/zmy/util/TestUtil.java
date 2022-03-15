package com.zmy.util;


import com.zmy.dao.impl.*;
import com.zmy.pojo.student.Student;
import com.zmy.pojotrait.Stu_score;
import org.junit.Test;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-11 20:13
 */
public class TestUtil {
    /**
     * 测试链接
     */
    @Test
    public void testcon(){
        System.out.println(DBUtil.getCon());
    }
    /**
     * 测试获取学生信息
     */
    @Test
    public void testGetStu(){
        StuDaoImpl stuDao = new StuDaoImpl();
        Student sam = stuDao.findStudentBySignUP(1001, "1","student");
        System.out.println(sam);
    }

    @Test
    public void testSignIn(){
        SignInDaoImpl signInDao = new SignInDaoImpl();
        System.out.println(signInDao.findByRoleAndid(1003));
    }
    @Test
    public void tes(){
        String s="";
        System.out.println(s.length());
    }
    @Test
    public void testGetscoreBysid(){
        ScoreDaoImpl scoreDao = new ScoreDaoImpl();
        List<Stu_score> scoreBysid = scoreDao.getScoreBysid(1001);
        System.out.println(scoreBysid);
    }
    @Test
    public void testSignUp(){
        SignUpDaoImpl signUpDao = new SignUpDaoImpl();
//        boolean teacher = signUpDao.findBySignUP(20011, "1", "teacher");
//        System.out.println(teacher);
    }
    @Test
    public void testgetSTUbyID(){
        StuDaoImpl stuDao = new StuDaoImpl();
        Student stuByid = stuDao.getStuByid(1001);
        System.out.println(stuByid);
    }
    // 测试分页
    @Test
    public void testP(){
        ScoreDaoImpl scoreDao = new ScoreDaoImpl();
        List<Stu_score> pagingScore = scoreDao.getPagingScore(1001, 2);
        System.out.println(pagingScore);
        System.out.println(pagingScore.get(0).toString());
        System.out.println(pagingScore.get(1).toString());

    }
    @Test
    public void testGetAllsocre(){
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        // 教师获取到所有成绩
//        List<ScoreVO> allStuScore = teacherDao.getAllStuScore();
//        System.out.println(allStuScore.size());
        // 获取最大页数
        System.out.println(teacherDao.getMaxPageSize(3));
    }
    // 测试学生成绩分页
    @Test
    public void testGetStuScore(){
        StuDaoImpl stuDao = new StuDaoImpl();
        List<Stu_score> scores = stuDao.getScoreBysid(1001, 1, 3);
        System.out.println(scores.size());

    }
}
