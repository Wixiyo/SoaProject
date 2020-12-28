package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public ResponseData findBookByUserId(String user) {
        Cart cart = cartRepository.findByUserId(user);
        return new ResponseData(ExceptionMsg.SUCCESS,cart);
    }
}
