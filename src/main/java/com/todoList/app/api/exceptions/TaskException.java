package com.todoList.app.api.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class TaskException {

	private String message;
	private ZonedDateTime timestamp;
	private HttpStatus httpStatus;
	private Throwable throwable;
	
	public TaskException(String message, ZonedDateTime timestamp, HttpStatus httpStatus, Throwable throwable) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.httpStatus = httpStatus;
		this.throwable = throwable;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}


	
}
