package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ConnectTest {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    //返回String,不带参数
    @Test
    public void test() {
        RestTemplate client= restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = client.getForEntity("http://localhost:8080/jersey/logistics/getLogistics/75414074668446/zhongtong", String.class);
        System.out.println(responseEntity.getBody());
    }
}
