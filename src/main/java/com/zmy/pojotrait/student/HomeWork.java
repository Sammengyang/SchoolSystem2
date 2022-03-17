package com.zmy.pojotrait.student;

import java.sql.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-17 11:44
 */
public class HomeWork {
    private Integer tid; // 发布人id
    private Integer cid; // 发布到的班级
    private String text; // 作业内容
    private Date startTime; // 发布时间
    private Date endTime;   // 截至日期

    public HomeWork() {
    }

    public HomeWork(Integer tid, Integer cid, String text, Date startTime, Date endTime) {
        this.tid = tid;
        this.cid = cid;
        this.text = text;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "tid=" + tid +
                ", cid=" + cid +
                ", text='" + text + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
