package com.zmy.dao;

import com.zmy.pojo.student.Massage;
import com.zmy.pojo.student.StuLeave;
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
     * 通过id获取个人信息
     *
     * @param id
     * @return
     */
    Teacher getMyInfo(Integer id);
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

    /**
     *  根的据登录人id 查看收到请假申请
     *
     * @param tid 教师id
     * @return 返回请假历史集合
     */
    List<StuLeave> leave_for_approvalServlet(Integer tid);

    /**
     * 根据提交请假申请人的id和申请时间，对数据状态进行修改
     *
     * @param id    申请人id
     * @param state 假条状态
     * @param startTime 离校时间
     * @return
     */
    boolean permitLeave(Integer id,String state,String startTime);

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
    boolean viewMasage(Integer id,String state);

    /**
     *  根据教师id，修改自己的信息
     *
     * @param id 教师id
     * @param teacher 存储要修改的信息
     * @return
     */
    boolean UpdateTeacherInfo(Integer id,Teacher teacher);
}
