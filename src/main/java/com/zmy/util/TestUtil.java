package com.zmy.util;


import com.zmy.dao.impl.SignInDaoImpl;
import com.zmy.dao.impl.StuDaoImpl;
import com.zmy.pojo.Student;
import org.junit.Test;

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
}
