package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.entity.User;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("logistics")
public class LogisticsController {
    @GET
    @Path("/getUserXml")
    @Produces(MediaType.APPLICATION_XML)
    public User getUserXml() {
        User user  = new User();
        user.setAge("21");
        user.setUserId("004");
        user.setUserName("Amand");
        return user;
    }
    @GET
    @Path("/getS")
    @Produces(MediaType.APPLICATION_XML)
    public String getS() {
        User user  = new User();
        user.setAge("21");
        user.setUserId("004");
        user.setUserName("Amand");
        return "user";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_XML)
    public String getArticleList() {
        return  "s";

    }
}
