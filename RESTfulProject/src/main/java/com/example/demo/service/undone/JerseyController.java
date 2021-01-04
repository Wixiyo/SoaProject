package com.example.demo.service.undone;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/api")
public class JerseyController {
    @GET
    @Path("/hello1")
    public String hello1() {
        return "hello";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/helloJson")
    public Map<String,Object> helloJson() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","1");
        map.put("codeMsg", "success");
        return map;
    }
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/helloXml")
    public Map<String,Object> helloXml() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","1");
        map.put("codeMsg", "success");
        return map;
    }
}
