package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@IdClass(CartUPK.class)
@Data
public class Cart {
    @Id
    private String userId;

    @Id
    private long bookId;
}
