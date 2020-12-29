package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Data
public class Cart {
    @Id
    private String userId;

    private long bookId;
}
