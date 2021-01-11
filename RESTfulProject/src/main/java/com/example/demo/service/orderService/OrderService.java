package com.example.demo.service.orderService;

import com.example.demo.dao.bookDao.Book;
import com.example.demo.dao.orderDao.Order;
import com.example.demo.dao.userDao.User;
import com.example.demo.dao.bookDao.BookRepository;
import com.example.demo.dao.orderDao.OrderRepository;
import com.example.demo.dao.userDao.UserRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {//订单管理服务
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseData order(Order order){
        orderRepository.save(order);
        bookRepository.updateStock(order.getBookId());
        return new ResponseData(ExceptionMsg.SUCCESS,order);
    }

    public ResponseData findBookByUserId(String user) {
        //List<Cart> cart = cartRepository.findByUserId(user);
        //Book book = bookRepository.findById(cart.getBookId());
        //return new ResponseData(ExceptionMsg.SUCCESS,book);
        List<Order> orders = new ArrayList<Order>(orderRepository.findByUserId(user));
        List<Book> books = new ArrayList<Book>();
        for(Order o:orders){
            books.add(bookRepository.findById(o.getBookId()));
        }
        if (books.size() != 0) {
            Object[] obj={books,orders};
            return new ResponseData(ExceptionMsg.SUCCESS,obj);
        }
        return new ResponseData(ExceptionMsg.FAILED,books);
    }

    public ResponseData findBooks() {
        List<Order> orders = new ArrayList<Order>(orderRepository.findAll());
        List<Book> books = new ArrayList<Book>();
        List<User> users = new ArrayList<User>();
        for(Order o:orders){
            books.add(bookRepository.findById(o.getBookId()));
            users.add(userRepository.findUser(o.getUserId()));
        }
        if (books.size() != 0) {
            Object[] obj={books,orders,users};
            return new ResponseData(ExceptionMsg.SUCCESS,obj);
        }
        return new ResponseData(ExceptionMsg.FAILED,books);
    }
    public ResponseData setLogisticByOrderId(String nuo,long id){
        orderRepository.updateLogistics(nuo,id);
        return new ResponseData(ExceptionMsg.SUCCESS);
    }
    public ResponseData checkOrderId(String nuo){
        orderRepository.updateStatus(nuo);
        return new ResponseData(ExceptionMsg.SUCCESS);
    }
}
