package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
