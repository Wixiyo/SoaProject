package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "booktransaction")
@Data
public class BookTransaction extends Transaction{

    @JoinColumn(name="USER_ID")//关联user表的字段
    @ManyToOne
    private User user;

    @JoinColumn(name="book_ID")
    @ManyToOne
    private Book book;

}
