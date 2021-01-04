package com.example.demo.config;

import com.example.demo.service.undone.JerseyController;
import com.example.demo.service.userService.LoginController;
import com.example.demo.service.logisticsService.LogisticsController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;


@Configuration
// 上下文路径，也可以配置在application.properties,未配置的话就是所有/*的请求，当前为/jersey/*
@ApplicationPath("/shop")
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig() {
        // 在这里注册相关Controller或者需要的特性支持
        register(JerseyController.class);
        register(LogisticsController.class);
        register(LoginController.class);
    }

}
