package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ConnectTest {
    @Test
    public void main() throws Exception{
        System.out.println("666");
        String com="zhongtong";
        String nu="75414074668446";
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
