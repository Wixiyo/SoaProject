package com.example.demo.service.cartService;

import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.Cart;
import com.example.demo.dao.repository.BookRepository;
import com.example.demo.dao.repository.CartRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {//购物车管理服务
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;

    public ResponseData findBookByUserId(String user) {
        //List<Cart> cart = cartRepository.findByUserId(user);
        //Book book = bookRepository.findById(cart.getBookId());
        //return new ResponseData(ExceptionMsg.SUCCESS,book);
        List<Cart> carts = new ArrayList<Cart>(cartRepository.findByUserId(user));
        List<Book> books = new ArrayList<Book>();
        for(Cart c:carts){
            books.add(bookRepository.findById(c.getBookId()));
        }
        if (books.size() != 0) {
            return new ResponseData(ExceptionMsg.SUCCESS,books);
        }
        return new ResponseData(ExceptionMsg.FAILED,books);
    }
}
