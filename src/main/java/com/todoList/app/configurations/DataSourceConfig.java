package com.todoList.app.configurations;

import java.util.Arrays; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataSourceConfig implements CommandLineRunner{


	@Override
	public void run(String...args) throws Exception {
		//Used to insert data when the app start..
		//List<String> names = Arrays.asList("ROLE_ADMIN", "ROLE_USER", "ROLE_DEVELOPER");
		//names.forEach(name -> rolRepository.save(new Rol(name)));  
	}
	
}
