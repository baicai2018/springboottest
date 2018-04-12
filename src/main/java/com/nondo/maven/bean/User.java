package com.nondo.maven.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {

    private Integer id;

    private String nameName;

    private String password;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;

    public User() {

    }

    public User(Integer id, String nameName, String password, Date birthday) {
        this.id = id;
        this.nameName = nameName;
        this.password = password;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameName() {
        return nameName;
    }

    public void setNameName(String nameName) {
        this.nameName = nameName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
