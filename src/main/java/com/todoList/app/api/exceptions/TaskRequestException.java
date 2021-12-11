package com.todoList.app.api.exceptions;

public class TaskRequestException extends RuntimeException {

	public TaskRequestException(String message) {
		super(message);
	}
	
	public TaskRequestException(String message, Throwable cause) {
		super(message,cause);
	}
}
