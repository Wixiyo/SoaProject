package com.example.demo.controller;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Merchandise;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.MerchandiseRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import com.example.demo.service.BookService;
import com.example.demo.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("bookinfo")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class BookController {
    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }
    protected Response result(){
        return new Response();
    }
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    //按名查找
    @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    public ResponseData findBook(@PathVariable("title") String title) throws IOException {
        return bookService.findBookByTitle(title);
    }
    //按id查找
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseData findBookById(@PathVariable("id") long id) throws IOException {
        return bookService.findBookById(id);
    }
    //查询全部
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseData findAllBook() throws IOException {
        return bookService.findAllBook();
    }
    //增
    @RequestMapping(value = "/addtocart", method = RequestMethod.POST)
    public ResponseData addtocart(Cart cart) {
        return bookService.addtocart(cart);
    }
}
