package com.todoList.app.configurations;

import java.util.Arrays; 
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.todoList.app.security.entity.Role;
import com.todoList.app.security.entity.User;
import com.todoList.app.security.enums.RoleName;
import com.todoList.app.security.repository.RolRepository;
import com.todoList.app.security.repository.UserRepository;


@Component
public class DataSourceConfig implements CommandLineRunner{

    @Autowired
    RolRepository rolRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
	@Override
	public void run(String...args) throws Exception {
		//Used to insert data when the app start..

		List<RoleName> names = Arrays.asList(RoleName.ROLE_ADMIN, RoleName.ROLE_USER, RoleName.ROL_DEVELOPER);
		names.forEach(name -> rolRepository.save(new Role(name)));  
		
		 
	/*
		User admin = new User("admin","admin",passwordEncoder.encode("1234"));
		admin.addRole(rolRepository.findByRolNombre(RoleName.ROLE_ADMIN).get());
		userRepository.save(admin);*/
	}
	
}
