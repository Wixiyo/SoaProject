package com.example.demo.controller;

import com.example.demo.repository.BookRepository;
import com.example.demo.repository.MerchandiseRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import com.example.demo.service.BookService;
import com.example.demo.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("bookinfo")
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

    //查
    @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    public ResponseData findBook(@PathVariable("title") String title) throws IOException {
        return bookService.findBookByTitle(title);
    }


}
