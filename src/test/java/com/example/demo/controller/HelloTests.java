package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.Cookie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    // GET http://localhost:8080/demo/querystringpojo?name=xxx&age=2
    // Content-Type:application/x-www-form-urlencoded
    @Test
    public void getVarsFromFormWithGetTest() throws Exception {

    this.mockMvc.perform(MockMvcRequestBuilders.get("/demo/querystringpojo")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("age", "100")
            .param("name", "zhangrui")
            )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.name").value("zhangrui"))
        .andExpect(jsonPath("$.data.age").value(100));
    }

    // POST http://localhost:8080/demo/querystringpojo
    // Content-Type:application/x-www-form-urlencoded
    //
    // name=xxx&age=2
    @Test
    public void getVarsFromFormWithPostTest() throws Exception {

    this.mockMvc.perform(MockMvcRequestBuilders.post("/demo/querystringpojo")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("age", "100")
            .param("name", "zhangrui")
            )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.name").value("zhangrui"))
        .andExpect(jsonPath("$.data.age").value(100));
    }

    // POST http://localhost:8080/demo/postpojo HTTP/1.1
    // content-type: application/json

    // {
    //     "name": "xxxxxx",
    //     "age": 22
    // }
    @Test
    public void getVarsFromRequestBodyTest() throws Exception {

    this.mockMvc.perform(MockMvcRequestBuilders.post("/demo/postpojo")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"zhangrui\",\"age\": 22}")
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.name").value("zhangrui"))
        .andExpect(jsonPath("$.data.age").value(22));
    }


    // GET http://localhost:8080/demo/querystringpojo?name=xxxx&age=22 HTTP/1.1
    @Test
    public void getVarsFromQueryStringWithPojoTest() throws Exception {

    this.mockMvc.perform(MockMvcRequestBuilders.get("/demo/querystringpojo").param("name", "zhangrui").param("age", "100"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.name").value("zhangrui"))
        .andExpect(jsonPath("$.data.age").value(100));
    }

    // GET http://localhost:8080/demo/querystring?name=zhangrui&age=100 HTTP/1.1
    @Test
    public void getVarsFromQueryStringTest() throws Exception {

    this.mockMvc.perform(MockMvcRequestBuilders.get("/demo/querystring").param("name", "zhangrui").param("age", "100"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.name").value("zhangrui"))
        .andExpect(jsonPath("$.data.age").value(100));
    }

    // GET http://localhost:8080/demo/querystring?age=100 HTTP/1.1
    @Test
    public void getVarsFromQueryStringWithDefaultValueTest() throws Exception {

    this.mockMvc.perform(MockMvcRequestBuilders.get("/demo/querystring").param("age", "100"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.name").value("aaa"))
        .andExpect(jsonPath("$.data.age").value(100));
    }

    // GET http://localhost:8080/demo/header HTTP/1.1
    // name: whyreal
    // age: 100
    @Test
    public void getVarsFromHeaderTest() throws Exception {

    this.mockMvc.perform(MockMvcRequestBuilders.get("/demo/header").header("name", "zhangrui").header("age", 100))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.name").value("zhangrui"))
        .andExpect(jsonPath("$.data.age").value(100));
    }

    // GET http://localhost:8080/demo/cookie
    // cookie: name=xxxx;age=22
    @Test
    public void getVarsFromCookieTest() throws Exception {

    this.mockMvc.perform(MockMvcRequestBuilders.get("/demo/cookie").cookie(new Cookie("name", "zhangrui"), new Cookie("age", "22")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.name").value("zhangrui"))
        .andExpect(jsonPath("$.data.age").value(22));
    }
}