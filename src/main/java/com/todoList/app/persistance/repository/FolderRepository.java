package com.todoList.app.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.todoList.app.persistance.model.Folder;
import com.todoList.app.persistance.model.Task;

@RepositoryRestResource(exported = false)
public interface FolderRepository extends JpaRepository<Folder, Long>{
	Folder findFolderById(Long id);
	Folder findFolderByName(String name);
}
