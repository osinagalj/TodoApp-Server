package com.todoList.app.persistance.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="Folder")
public class Folder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "name", nullable = false,unique=true)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "task_id")
	private Set<Task> tasks = new HashSet<>();
	
	public Folder() {}
	
	public Folder(String name) {
		this.name = name;
	}
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	

	public Set<Task> getTasks() {
		return tasks;
	}


	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}

