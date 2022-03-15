package com.zmy.pojo.teacher;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-15 10:08
 */
public class ScoreVO {
    private Integer sid;
    private String sname;
    private String major;
    private String cname;
    private String credit;
    private String score;
    private String examTime;

    public ScoreVO() {
    }

    public ScoreVO(Integer sid, String sname, String major, String cname,String credit, String score, String examTime) {
        this.sid = sid;
        this.sname = sname;
        this.major = major;
        this.cname = cname;
        this.credit = credit;
        this.score = score;
        this.examTime = examTime;
    }

    @Override
    public String toString() {
        return "TScores{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", major='" + major + '\'' +
                ", credit='" + credit + '\'' +
                ", score='" + score + '\'' +
                ", examTime='" + examTime + '\'' +
                '}';
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }
}
