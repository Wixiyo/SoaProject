package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class Deal {
    private long deal_id;
    private String com;
    private String nu;
    private String phone;
}
