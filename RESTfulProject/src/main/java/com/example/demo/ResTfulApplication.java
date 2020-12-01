package com.example.demo;

import com.example.demo.config.JerseyConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ResTfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResTfulApplication.class, args);
	}

	/*
	@Bean
	public ServletRegistrationBean jerseyServlet(){
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(),  "/jersey/*");
        // our rest resources will be available in the path /jersey/*
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
        return registration;
    }*/
}
