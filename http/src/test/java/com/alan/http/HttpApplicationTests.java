package com.alan.http;

import com.alan.http.utils.ResponseResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpApplicationTests {

    @Test
    public void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseResult object = restTemplate.getForObject("https://www.baidu.com", ResponseResult.class);
        System.out.println(object);
    }
    @Test
    public void test(){
        Date date = new Date();
        System.out.println(date.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

}
