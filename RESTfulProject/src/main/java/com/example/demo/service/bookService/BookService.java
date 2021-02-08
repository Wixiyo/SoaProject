package com.example.demo.service.bookService;

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
public class BookService {//书籍管理服务

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;

    public ResponseData findBookByTitle(String title) {
        List<Book> books = new ArrayList<Book>(bookRepository.findByTitle(title));
        if (books.size() != 0) {
            return new ResponseData(ExceptionMsg.SUCCESS,books);
        }
        return new ResponseData(ExceptionMsg.FAILED,books);
    }
    public ResponseData findBookById(long id) {
        Book book = bookRepository.findById(id);
        if (book != null) {
            return new ResponseData(ExceptionMsg.SUCCESS,book);
        }
        return new ResponseData(ExceptionMsg.FAILED,book);
    }
    public ResponseData findAllBook() {
        List<Book> books = new ArrayList<Book>(bookRepository.findAll());
        if (books.size() != 0) {
            return new ResponseData(ExceptionMsg.SUCCESS,books);
        }
        return new ResponseData(ExceptionMsg.FAILED,books);
    }

    public ResponseData addtocart(Cart cart){
        cartRepository.save(cart);
        return new ResponseData(ExceptionMsg.SUCCESS,cart);
    }

    public ResponseData addbook(Book book){
        bookRepository.save(book);
        return new ResponseData(ExceptionMsg.SUCCESS,book);
    }

}
