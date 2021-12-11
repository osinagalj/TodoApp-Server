package com.todoList.app.persistance.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.todoList.app.persistance.model.Task;

@RepositoryRestResource(exported = false)
public interface TaskRepository extends PagingAndSortingRepository<Task, Long>{

	Task findByName(String name);
	Task findTasktById(Long id);
	//Task findTasktByFolder(Long id);
}
