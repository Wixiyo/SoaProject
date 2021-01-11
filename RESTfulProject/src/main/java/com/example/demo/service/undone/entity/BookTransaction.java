package com.example.demo.service.undone.entity;

import com.example.demo.dao.Transaction;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "booktransaction")
@Data
public class BookTransaction extends Transaction {
    @Column(nullable = false,length = 15)
    private String userId;

    @Column(nullable = false)
    private long bookId;

}
