package com.zmy.dao;

import com.zmy.pojo.Student;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-14 15:13
 */
public interface SignUpDao {
    /**
     * 根据账号和密码对role表进行查询
     *
     * @param id 账号
     * @param pwd 密码
     * @return  如果查询到返回student对象，否则返回null
     */
    boolean findBySignUP(Integer id, String pwd, String role);
}
