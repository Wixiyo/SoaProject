package com.example.demo;


import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/")
@Component
public class JerseyTest {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public Map<String,Object> hello() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","1");
        map.put("codeMsg", "success");
        return map;
    }
}
