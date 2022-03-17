package com.zmy.pojotrait.student;

import java.util.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-13 13:51
 */
public class Stu_score {
    private Integer id; // 考试编号
    private Integer sid; // 学号
    private String  major; //专业
    private String cname; // 课程名
    private String credit; // 学分
    private String score; // 成绩
    private Date exam_time; // 考试时间

    public Stu_score() {
    }

    public Stu_score(Integer id, Integer sid, String major, String cname, String credit, String score, Date exam_time) {
        this.id = id;
        this.sid = sid;
        this.major = major;
        this.cname = cname;
        this.credit = credit;
        this.score = score;
        this.exam_time = exam_time;
    }

    @Override
    public String toString() {
        return "Stu_score{" +
                "id=" + id +
                ", sid=" + sid +
                ", major='" + major + '\'' +
                ", cname='" + cname + '\'' +
                ", credit='" + credit + '\'' +
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
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
