package com.example.demo.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Record")
@Data
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int type;

}
