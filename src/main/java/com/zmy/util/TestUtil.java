package com.zmy.util;


import com.zmy.dao.impl.SignInDaoImpl;
import com.zmy.dao.impl.SignUpDaoImpl;
import com.zmy.dao.impl.ScoreDaoImpl;
import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.dao.impl.TeacherDaoImpl;
import com.zmy.pojotrait.student.StuLeave;
import com.zmy.pojo.student.Student;
import com.zmy.pojo.teacher.Teacher;
import com.zmy.pojotrait.student.Stu_score;
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
    // 测试请假功能
    @Test
    public void testApplyHoliday(){
        StuDaoImpl stuDao = new StuDaoImpl();
        StuLeave stuLeave = new StuLeave();
        stuLeave.setSid(1001);
        stuLeave.setSname("sam");
        stuLeave.setTid(20011);
        stuLeave.setText("病假");
        stuLeave.setStartTime("2020-12-12");
        stuLeave.setEndTime("2020-12-13");
        stuDao.applyHoliday(stuLeave);
    }
    // 测试查看历史假条
    @Test
    public void testGetHistory(){
        StuDaoImpl stuDao = new StuDaoImpl();
        List<StuLeave> historyHoliday = stuDao.getHistoryHoliday(1001);
        System.out.println(historyHoliday.size());
    }
    // 测试教师查看请假申请
    @Test
    public void testCheck(){
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        List<StuLeave> list = teacherDao.leave_for_approvalServlet(20011);
        System.out.println(list.size());
    }
    // 测试审批假条
    @Test
    public void testPermit(){
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        boolean b = teacherDao.permitLeave(1001, "已同意", "2020-10-13");
        System.out.println(b);
    }

    // 测试学生老师查看消息
    @Test
    public void testst(){
        StuDaoImpl stuDao = new StuDaoImpl();
        stuDao.viewMassage(4564564,"已读");
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.viewMasage(8795646,"已读");
    }
    // 测试学生和教师修改信息
    @Test
    public void changeInfo(){
        // 学生
//        StuDaoImpl stuDao = new StuDaoImpl();
//        Student student = new Student(
//                "张孟洋","123456","男","2000-12-28","2018-09-01","电信","12","15039947675"
//        );
//        stuDao.UpdateStudentInfo(1006,student);
        // 教师
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        Teacher teacher = new Teacher("sam","2","110");
        boolean b = teacherDao.UpdateTeacherInfo(20011, teacher);
        System.out.println(b);
    }
}
