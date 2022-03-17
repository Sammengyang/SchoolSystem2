package com.zmy.dao;

import com.zmy.pojotrait.student.Stu_score;

import java.util.List;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-13 13:56
 */
public interface ScoreDao {
    /**
     *  根据sid查询学生的历史成绩
     * @param sid
     * @return 返回成绩集合
     */
    List<Stu_score> getScoreBysid(Integer sid);

    /**
     * 根据id查询对应学生成绩，并根据页数进行分页
     * @param sid
     * @param num
     * @return
     */
    List<Stu_score> getPagingScore(Integer sid,Integer num);
}
