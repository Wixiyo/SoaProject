package com.example.demo.config;

import com.example.demo.controller.JerseyController;
import com.example.demo.resources.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;


@Configuration
// 上下文路径，也可以配置在application.properties,未配置的话就是所有/*的请求，当前为/jersey/*
@ApplicationPath("/jersey")
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig() {
        // 在这里注册相关Controller或者需要的特性支持
        register(JerseyController.class);
        register(UserResource.class);
    }

}
