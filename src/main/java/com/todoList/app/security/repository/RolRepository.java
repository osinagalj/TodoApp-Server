package com.todoList.app.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoList.app.security.entity.Role;
import com.todoList.app.security.enums.RoleName;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRolNombre(RoleName rolNombre);
}
