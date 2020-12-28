package com.example.demo.controller;

import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.service.BookService;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

public class CartController {
    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }
    protected Response result(){
        return new Response();
    }
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartService cartService;
}
