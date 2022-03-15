package com.zmy.pojo.student;

import java.util.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-11 19:51
 */
public class Student {
    private Integer sid;
    private String sname;
    private String gender; // 性别
    private String pwd;
    private String birthday;
    private String inschool_time;
    private String major;
    private String tel;
    private String role;
    private String cid;

    public Student() {
    }

    public Student(Integer sid, String sname, String pwd, String tel,String role) {
        this.sid = sid;
        this.sname = sname;
        this.pwd = pwd;
        this.tel = tel;
        this.role = role;
    }

    public Student(Integer sid, String sname, String gender, String pwd, String birthday, String inschool_time, String major, String tel, String role, String cid) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.pwd = pwd;
        this.birthday = birthday;
        this.inschool_time = inschool_time;
        this.major = major;
        this.tel = tel;
        this.role = role;
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", pwd='" + pwd + '\'' +
                ", birthday=" + birthday +
                ", inschool_time=" + inschool_time +
                ", major='" + major + '\'' +
                ", tel='" + tel + '\'' +
                ", role='" + role + '\'' +
                ", cid='" + cid + '\'' +
                '}';
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getInschool_time() {
        return inschool_time;
    }

    public void setInschool_time(String inschool_time) {
        this.inschool_time = inschool_time;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
