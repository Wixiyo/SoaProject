package com.example.demo.dao.orderDao;

import com.example.demo.dao.Transaction;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book_order")
@Data
public class Order extends Transaction {

    private String status;

    private String userId;

    private long bookId;

    private String address;

    private String logistic;
}
