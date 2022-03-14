package com.zmy.pojo;

import java.util.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-14 16:59
 */
public class Scores {
    private Integer id; // 成绩编号
    private Integer sid; // 学生编号
    private String cid; // 课程号
    private String score; // 成绩
    private Date exam_time; // 考试时间

    public Scores() {
    }

    public Scores(Integer id, Integer sid, String cid, String score, Date exam_time) {
        this.id = id;
        this.sid = sid;
        this.cid = cid;
        this.score = score;
        this.exam_time = exam_time;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "id=" + id +
                ", sid=" + sid +
                ", cid='" + cid + '\'' +
                ", score='" + score + '\'' +
                ", exam_time=" + exam_time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getExam_time() {
        return exam_time;
    }

    public void setExam_time(Date exam_time) {
        this.exam_time = exam_time;
    }
}
