package com.hzx.opac;


import com.hzx.opac.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

public class TestUser {

    private static ApplicationContext ctx;

    private RestTemplate mockClient;
    private static final String BASE_URL = "http://localhost:8080/user/";

    @Before
    public void beforeTest(){
        mockClient = new RestTemplate();
    }

    @After
    public void afterTest(){

    }
    @Test
    public void TestLogin() {
        String result = mockClient.getForObject(BASE_URL + "login?username=pp&password=00"
                ,String.class);
        System.out.println(result);
    }

    @Test
    public void TestRegister(){
        User user = new User();
        user.setUsername("aa");
        user.setPassword("bb");
        String result = mockClient.postForObject(BASE_URL + "register", user, String.class);
        System.out.println(result);
    }

    @Test
    public void TestModifyUser(){
        User user = new User();
        user.setUserId(6);
        user.setPassword("11");

        String result = mockClient.postForObject(BASE_URL + "modify",user, String.class);
        System.out.println(result);
    }

    @Test
    public void TestGetUser(){
        String result = null;
        result = mockClient.getForObject(BASE_URL + "6", String.class);
        System.out.println(result);
    }


}
