package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "booktransaction")
@Data
public class BookTransaction extends Transaction{
    @Column(nullable = false,length = 15)
    private String userId;

    @Column(nullable = false)
    private long bookId;

}
