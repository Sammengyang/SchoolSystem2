package com.zmy.dao;

import com.zmy.pojo.student.Massage;
import com.zmy.pojo.student.StuLeave;
import com.zmy.pojo.student.Student;
import com.zmy.pojotrait.Stu_score;

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
     * 学生修改自己的个人信息
     *
     * @param sid 发起修改信息申请的人的id
     * @param student 存储修改的信息
     * @return
     */
    boolean UpdateStudentInfo(Integer sid,Student student);

    Student getStuByid(Integer id);

    /**
     *  根据id或去对应人的历史成绩
     *
     * @param id
     * @return
     */
    List<Stu_score> getScoreBysid(Integer id);

    /**
     *
     * @param id  学生id
     * @param page 页数
     * @param pageSize 页面展示数据数
     * @return
     */
    List<Stu_score> getScoreBysid(Integer id,Integer page,Integer pageSize);

    /**
     *  根据id获取该学省的成绩最大页数
     * @param id 学号
     * @return
     */
    Integer getMaxPage(Integer id,Integer pageSize);

    /**
     *  学生请假，向请假表插入数据
     *
     */
    void applyHoliday(StuLeave stuLeave);

    /**
     *  根据登录人id查询请假历史
     * @param id 登录人id
     * @return
     */
    List<StuLeave> getHistoryHoliday(Integer id);

    /**
     * 根据权限展示能看到的消息
     *
     * @param role 登录人角色
     * @return
     */
    List<Massage> getMassage(String role);

    /**
     *  根据消息id修改消息状态
     * @param id
     * @param state
     * @return
     */
    boolean viewMassage(Integer id,String state);
}
