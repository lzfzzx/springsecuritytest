package com.example.springsecuritytest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
//写任何代码时，测试用例先行,可以方便重构，保证程序逻辑不会出问题
@SpringBootTest
class SpringsecuritytestApplicationTests {
    //    伪造一个MVC环境，执行测试用例会很快，不会去启动tomcat
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    //    BeforeEach会在每个测试用例执行前去执行一次
    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void whenQuerySuccess() throws Exception{
        String result =mockMvc.perform(MockMvcRequestBuilders.get("/user") //mockMvc去执行模拟发出一个get请求
//                .param("username","lzf")
                .param("username", "lzf")
                .param("age", "18")
                .param("ageTo","60")
                .param("xxx","yyyy")
//                .param("size","15")
//                .param("page","3")
//                .param("sort","age,desc")
                .contentType(MediaType.APPLICATION_JSON))  //contentType为json
                .andExpect(MockMvcResultMatchers.status().isOk()) //期望服务器端返回的结果的状态码是200
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))//期望返回的是一个集合，集合长度为3
                .andReturn().getResponse().getContentAsString();//将服务器返回的json字符串当成一个String变量返回回去
        System.out.println(result);
    }


    @Test
    public void whenGetInfoSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect((MockMvcResultMatchers.jsonPath("$.username").value("tom")))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenGetInfoFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/a")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }


}
