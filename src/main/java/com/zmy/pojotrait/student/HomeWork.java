package com.zmy.pojotrait.student;

import com.zmy.dao.ScoreDao;

import java.sql.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-17 11:44
 */
public class HomeWork {
    private Integer tid; // 发布人id
    private String tname;   // 发布人姓名
    private Integer cid; // 发布到的班级
    private String text; // 作业内容
    private String startTime; // 发布时间
    private String endTime;   // 截至日期
    private Integer sid; // 提交人id
    private String postTime; // 提交时间
    private String jobContent; // 作业
    private Integer score; // 作业分数



    public HomeWork() {
    }

    public HomeWork(Integer sid, Integer cid, String text, String postTime,Integer score) {
        this.sid =sid;
        this.cid = cid;
        this.text = text;
        this.postTime = postTime;
        this.score = score;
    }

    public HomeWork(Integer tid, Integer cid, String text, String startTime, String endTime) {
        this.tid = tid;
        this.cid = cid;
        this.text = text;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public HomeWork(String tname,Integer cid, String text, String startTime, String endTime,String jobContent,Integer score) {
        this.tname = tname;
        this.cid = cid;
        this.text = text;
        this.startTime = startTime;
        this.endTime = endTime;
        this.jobContent = jobContent;
        this.score = score;
    }

    public HomeWork(Integer sid, String submitTime, String jobcontent) {
        this.sid = sid;
        this.postTime = submitTime;
        this.jobContent = jobcontent;
    }


    @Override
    public String toString() {
        return "HomeWork{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", cid=" + cid +
                ", text='" + text + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", sid=" + sid +
                ", postTime='" + postTime + '\'' +
                ", jobContent='" + jobContent + '\'' +
                ", score=" + score +
                '}';
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
