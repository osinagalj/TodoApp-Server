package com.todoList.app.api.dto;


public class TaskInput {

	private String name;
	private Boolean done;
	private Long folder_id;
	
	public TaskInput() {
		
	}
	
	public TaskInput(String name, Boolean done) {
		super();
		this.name = name;
		this.done = done;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}

	public Long getFolder_id() {
		return folder_id;
	}

	public void setFolder_id(Long folder_id) {
		this.folder_id = folder_id;
	}




	
}
