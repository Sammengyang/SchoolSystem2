package com.zmy.dao;

import com.zmy.pojo.teacher.ScoreVO;
import com.zmy.pojo.teacher.Teacher;

import java.util.List;

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

    /**
     * 教师查询自己学生的成绩
     *
     * @return list 返回学生成绩集合
     */
    List<ScoreVO> getAllStuScore();

    /**
     * 分页查看学生成绩
     *
     * @param page 页数
     * @param pageSize 页面展现条数
     * @return
     */
    List<ScoreVO> getAllStuScore(Integer page,Integer pageSize);

    /**
     * 获取总页数
     *
     * @param pageSize 每页的数据数
     * @return
     */
    Integer getMaxPageSize(Integer pageSize);
}
