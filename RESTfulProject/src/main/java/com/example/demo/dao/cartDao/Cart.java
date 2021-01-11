package com.example.demo.dao.cartDao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Data
public class Cart {

    private long id;

    private String  userId;

    @Id
    private long  bookId;

}
