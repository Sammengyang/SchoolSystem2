package com.zmy.dao;

import com.aliyun.tea.Tea;
import com.zmy.pojo.Student;
import com.zmy.pojo.Teacher;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-12 11:01
 */
public interface SignInDao {
    /**
     * 根据role确认查询到的表，根据id查询该账户是否存在学校系统
     *
     * @param sid
     * @return
     */
    Student findByRoleAndid(Integer sid);

    /**
     * 注册成功将该学生加入数据库
     *
     * @param student
     */
    void AddStudent(Student student);

    void AddTeacher(Teacher teacher);

}
