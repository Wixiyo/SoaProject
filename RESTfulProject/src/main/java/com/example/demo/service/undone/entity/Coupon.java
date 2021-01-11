package com.example.demo.service.undone.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Coupon")
@Data
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double takeoff;

    @Column(nullable = false)
    private double con;

}
