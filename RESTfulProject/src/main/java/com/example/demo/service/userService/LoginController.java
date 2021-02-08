package com.example.demo.service.userService;

import com.example.demo.dao.entity.User;
import com.example.demo.dao.repository.UserRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import com.example.demo.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/{id}/{password}", method = RequestMethod.GET)
    public ResponseData login(@PathVariable("id") String i,@PathVariable("password") String p) {
        return userService.check(i,p);
    }

}
