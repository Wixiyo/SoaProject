package com.example.demo.controller;


import com.example.demo.entity.Deal;

import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/logistics")
public class LogisticsController {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @GET
    //@Path("/getLogistics/{nu}/{com}")
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserXml(@PathParam("id") String id) {
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
