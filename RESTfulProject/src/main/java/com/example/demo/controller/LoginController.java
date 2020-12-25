package com.example.demo.controller;

import com.example.demo.entity.Merchandise;
import com.example.demo.entity.User;
import com.example.demo.repository.MerchandiseRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import com.example.demo.service.MerchandiseService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class LoginController {

    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }
    protected Response result(){
        return new Response();
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    @Autowired
    UserService userService;

    //增
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseData add(User user) {
        return userService.add(user);
    }

    //查
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ResponseData login() {
        return userService.check();
    }

}
