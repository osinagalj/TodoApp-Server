package com.todoList.app.config;


import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import com.todoList.app.AppApplication;

import io.cucumber.java.Before;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = AppApplication.class, loader = SpringBootContextLoader.class)
public class CucumberConfig {


    @Before
    public void setupCucumberSpringContext(){
    }
    


}
