package com.zmy.pojotrait.student;

import java.sql.Date;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-03-16 10:56
 */
public class Massage {
    private Integer id; // 消息编号
    private String pname; // 发布人信息
    private String title; // 消息头
    private String text; // 内容
    private Date postTime; // 发布时间
    private String role; // 允许查看人

    public Massage() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Massage(Integer id, String pname, String title, String text, Date postTime, String role) {
        this.id = id;
        this.pname = pname;
        this.title = title;
        this.text = text;
        this.postTime = postTime;
        this.role = role;
    }
}
