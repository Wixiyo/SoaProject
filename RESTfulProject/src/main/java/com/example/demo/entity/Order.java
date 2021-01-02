package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "book_order")
@Data
public class Order extends Transaction{

    private String status;

    private String userId;

    private long bookId;

    private String address;

    private String logistic;
}
