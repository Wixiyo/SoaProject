package com.example.demo.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @Column(nullable = false,length = 15)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,length = 11)
    private String phone;

    @Column(nullable = false)
    private String userName;

    private String address;

}
