package com.zmy.dao;

import com.zmy.pojo.Teacher;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-12 9:58
 */
public interface TeacherDao {
    /**
     * 根据身份确认查询的表格,根据账号密码来查询人
     *
     * @param tid
     * @param password
     * @param role
     * @return
     */
    Teacher GetTeacherBytid(Integer tid,String password,String role);

}
