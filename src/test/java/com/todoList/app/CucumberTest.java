package com.todoList.app;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
					glue = "com.todoList.app")
public class CucumberTest {
	
}