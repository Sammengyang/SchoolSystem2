package com.zmy.dao;

import com.zmy.pojo.Student;
import com.zmy.pojo.Teacher;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-14 15:13
 */
public interface SignUpDao {
    /**
     * 根据账号和密码对role表进行查询
     *
     * @param sid 账号
     * @param pwd 密码
     * @return  如果查询到返回student对象，否则返回null
     */

    Student GetStudentByid(Integer sid, String pwd, String role);

    /**
     * 根据role和账号，密码判断是否登录成功
     * @param tid 编号
     * @param password 密码
     * @param role 角色
     * @return
     */
    Teacher GetTeacherBytid(Integer tid, String password, String role);

}
