package com.example.demo.service.orderService;

import com.example.demo.dao.entity.Order;
import com.example.demo.dao.repository.CartRepository;
import com.example.demo.dao.repository.OrderRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class OrderController {
    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }
    protected Response result(){
        return new Response();
    }
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderService orderService;

    //增
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseData order(Order order) {
        return orderService.order(order);
    }

    //查
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseData searchOrder(@PathVariable("id") String id) {
        return orderService.findBookByUserId(id);
    }
    //查
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseData searchAllOrder() {
        return orderService.findBooks();
    }
    //改
    @RequestMapping(value = "/{id}/{nuo}", method = RequestMethod.GET)
    public ResponseData searchOrder(@PathVariable("id") long id,@PathVariable("nuo") String nuo) {
        return orderService.setLogisticByOrderId(nuo,id);
    }

}
