package com.zmy.dao;

import com.zmy.pojo.Scores;
import com.zmy.pojo.Student;

import java.util.List;


/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-11 20:23
 */
public interface StuDao {

    /**
     * 根据学号和密码对student表进行查询
     *
     * @param sid 学号
     * @param pwd 密码
     * @return  如果查询到返回student对象，否则返回null
     */
    Student findStudentBySignUP(Integer sid, String pwd, String role);

    /**
     * 学生注册
     *
     * @param sid
     * @param pwd
     * @param role
     */
    void UpdateStudentInfo(String sid,String pwd,String role);

    Student getStuByid(Integer id);

    /**
     *  根据id或去对应人的历史成绩
     *
     * @param id
     * @return
     */
    List<Scores> getScoreBysid(Integer id);
}
