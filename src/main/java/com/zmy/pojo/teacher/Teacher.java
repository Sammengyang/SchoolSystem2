package com.zmy.pojo.teacher;

import java.util.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-11 19:51
 */
public class Teacher {
    private Integer tid;
    private String tname;
    private String pwd;
    private String role;
    private Date inschool_time;
    private String tel;

    public Teacher() {
    }

    public Teacher(String tname, String pwd,  String tel) {
        this.tname = tname;
        this.pwd = pwd;
        this.tel = tel;
    }

    public Teacher(Integer tid, String tname, String pwd, String role, Date inschool_time, String tel) {
        this.tid = tid;
        this.tname = tname;
        this.pwd = pwd;
        this.role = role;
        this.inschool_time = inschool_time;
        this.tel = tel;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getInschool_time() {
        return inschool_time;
    }

    public void setInschool_time(Date inschool_time) {
        this.inschool_time = inschool_time;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", role='" + role + '\'' +
                ", inschool_time=" + inschool_time +
                ", tel='" + tel + '\'' +
                '}';
    }
}
