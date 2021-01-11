package com.example.demo.service.logisticsService;


import com.example.demo.config.HttpClientHelper;
import com.example.demo.service.undone.entity.Deal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@RestController
@RequestMapping("logistics")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class LogisticsController {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    @Autowired
    HttpClientHelper httpClientHelper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String SearchLogistics(@PathVariable("id") String id) throws IOException {
        Deal deal=new Deal();
        //deal.setNu(nu);
        //deal.setCom(com);
        return GetLogistics2(id);
    }
    private String GetLogistics(String nuo){
        RestTemplate client= restTemplateBuilder.build();
        String a = "https://route.showapi.com/2435-1?showapi_appid=451917&nuo="+nuo+"&showapi_sign=f8ca729443174ba1b73952f4c45b677c";
        ResponseEntity<String> responseEntity = client.getForEntity(a,String.class);
        //ResponseEntity<String> responseEntity = client.getForEntity("http://route.showapi.com/64-34?showapi_appid=451917&com={1}&nu={2}&callBackUrl=xxx&phone=&outCode=&showapi_sign=f8ca729443174ba1b73952f4c45b677c", String.class,deal.getCom(),deal.getNu());
        return responseEntity.getBody();
}
    private String GetLogistics2(String nuo) throws IOException {
        String a = "https://route.showapi.com/2435-1?showapi_appid=451917&nuo="+nuo+"&showapi_sign=f8ca729443174ba1b73952f4c45b677c";
        return httpClientHelper.sendGet(a);
    }



}
