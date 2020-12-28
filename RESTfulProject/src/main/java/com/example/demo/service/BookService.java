package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Merchandise;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.MerchandiseRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseData findBookByTitle(String title) {
        List<Book> books = new ArrayList<Book>(bookRepository.findByTitle(title));
        if (books.size() != 0) {
            return new ResponseData(ExceptionMsg.SUCCESS,books);
        }
        return new ResponseData(ExceptionMsg.FAILED,books);
    }
}
