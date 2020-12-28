package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Record")
@Data
public class Record {
    @Id
    private String id;

    @Column(nullable = false)
    private int type;

}
