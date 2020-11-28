package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.entity.Deal;
import com.example.demo.entity.User;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/logistics")
public class LogisticsController {
    @GET
    @Path("/getLogistics/{nu}/{com}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserXml(@PathParam("nu") String nu,@PathParam("com") String com) {
        Deal deal=new Deal();
        deal.setNu(nu);
        deal.setCom(com);
        String s = SearchLogistics(com,nu);
        return s;
    }

    private String SearchLogistics(String com,String nu){
        com="zhongtong";
        nu="75414074668446";
        BufferedReader in = null;
        try {
            //获取访问地址URL,注意GET请求若URL中包含中文字符的话,在高版本TOMCAT中会认为是不合法字符,可改为POST方式
            URL url = new URL("http://route.showapi.com/64-34?showapi_appid=451917&com="+com+"&nu="+nu+"&callBackUrl=xxx&phone=&outCode=&showapi_sign=f8ca729443174ba1b73952f4c45b677c");
            //创建HttpURLConnection对象
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //请求方式,默认是GET
            conn.setRequestMethod("GET");
            //连接主机的超时时间（单位：毫秒）
            conn.setConnectTimeout(30000);
            //从主机读取数据的超时时间（单位：毫秒）
            conn.setReadTimeout(30000);
            //设置是否输出,默认是false
            conn.setDoOutput(false);
            //设置是否读入,默认是true
            conn.setDoInput(true);
            String result = "";
            int code = conn.getResponseCode();
            if(code == 200){
                //定义BufferedReader输入流读取响应,getInputStream()会自动建立连接,无需手动调用connect()连接
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                //关闭输入流
                in.close();
            }
            System.out.println("返回结果："+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }


}
