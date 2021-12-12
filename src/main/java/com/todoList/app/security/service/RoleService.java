package com.todoList.app.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todoList.app.security.entity.Role;
import com.todoList.app.security.enums.RoleName;
import com.todoList.app.security.repository.RolRepository;

import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Role> getByRolNombre(RoleName roleName){
        return rolRepository.findByRolNombre(roleName);
    }

    public void save(Role rol){
        rolRepository.save(rol);
    }
}
