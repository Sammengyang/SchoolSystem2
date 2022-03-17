package com.zmy.pojotrait.student;

import java.util.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-15 17:38
 */
public class StuLeave {
    private Integer sid; // 请假人id
    private String sname;  // 请假人姓名
    private Integer tid; // 审批人
    private String tname; // 审批人姓名
    private String text; // 假条内容
    private String startTime; // 开始时间
    private String endTime; //结束时间
    private String state;

    public StuLeave() {
    }

    public StuLeave(Integer sid,String sname, Integer tid,String tname, String text, String startTime, String endTime,String state) {
        this.sid = sid;
        this.sname = sname;
        this.tid = tid;
        this.tname = tname;
        this.text = text;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
    }

    @Override
    public String toString() {
        return "StuLeave{" +
                ", sid=" + sid +
                ", tid=" + tid +
                ", text='" + text + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", state='" + state + '\'' +
                '}';
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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
