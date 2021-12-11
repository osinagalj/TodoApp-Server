package com.todoList.app.persistance.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.todoList.app.persistance.model.Rol;


@RepositoryRestResource(exported = false)
public interface RolRepository extends PagingAndSortingRepository<Rol, Long>{

	Rol findByName(String name);
	Rol findUserById(Long id);
}
