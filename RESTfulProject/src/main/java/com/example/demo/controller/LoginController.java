package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.result.ResponseData;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/login")
public class LoginController {

    @Autowired
    protected UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public ResponseData register(@FormParam("userId") String userId,@FormParam("userName") String username,
                                 @FormParam("password") String password,
                                 @FormParam("phone") String phone) {
        User user = new User();
        user.setPassword(password);
        user.setUserId(userId);
        user.setUserName(username);
        user.setPhone(phone);
        return userService.add(user);
    }

    @Path("login")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public User postUser(@FormParam("userName") String username){
        User user = new User();
        System.out.println(username);
        user.setUserName(username);
        user.setPassword("涛哥");
        return user;
    }

}
