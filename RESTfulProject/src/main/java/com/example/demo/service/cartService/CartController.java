package com.example.demo.service.cartService;

import com.example.demo.dao.repository.CartRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseData searchcart(@PathVariable("id") String id) {
        return cartService.findBookByUserId(id);
    }
}
