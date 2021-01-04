package com.example.demo.service.logisticsService;


import com.example.demo.dao.entity.Deal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("logistics")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class LogisticsController {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserXml(@PathVariable("id") String id) {
        Deal deal=new Deal();
        //deal.setNu(nu);
        //deal.setCom(com);
        return SearchLogistics(id);
    }
    private String SearchLogistics(String nuo){
        RestTemplate client= restTemplateBuilder.build();
        String a = "https://route.showapi.com/2435-1?showapi_appid=451917&nuo="+nuo+"&showapi_sign=f8ca729443174ba1b73952f4c45b677c";
        ResponseEntity<String> responseEntity = client.getForEntity(a,String.class);
        //ResponseEntity<String> responseEntity = client.getForEntity("http://route.showapi.com/64-34?showapi_appid=451917&com={1}&nu={2}&callBackUrl=xxx&phone=&outCode=&showapi_sign=f8ca729443174ba1b73952f4c45b677c", String.class,deal.getCom(),deal.getNu());
        return responseEntity.getBody();
}



}
