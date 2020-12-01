package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("shop")
public class ThymeleafController {
    @GetMapping("/map")
    public ModelAndView map() {
        Map user= new HashMap();
        user.put("name", "xinyao");
        user.put("sex", "男");
        ModelAndView modelAndView = new ModelAndView("map");
        modelAndView.addObject("map", user);
        return modelAndView;
    }
}
