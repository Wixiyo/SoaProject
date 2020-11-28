package com.example.demo.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private String userId;
    private String userName;
    private String age;

    @XmlElement
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @XmlElement
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlElement
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User() {};

    public User(String userId, String userName, String age) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }
}
