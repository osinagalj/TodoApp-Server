package com.todoList.app.configurations;

import java.util.Arrays; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.todoList.app.security.entity.Rol;
import com.todoList.app.security.enums.RolNombre;
import com.todoList.app.security.repository.RolRepository;



@Component
public class DataSourceConfig implements CommandLineRunner{

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public void run(String...args) throws Exception {
		List<RolNombre> names = Arrays.asList(RolNombre.ROLE_USER, RolNombre.ROLE_ADMIN);
		names.forEach(name -> rolRepository.save(new Rol(name)));  
	}
	
}
