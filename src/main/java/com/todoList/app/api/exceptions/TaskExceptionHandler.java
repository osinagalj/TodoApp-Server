package com.todoList.app.api.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskExceptionHandler {
	
	@ExceptionHandler (value = {TaskRequestException.class})
	public ResponseEntity<Object> handleTaskRequestException(TaskRequestException ex){
		
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		TaskException t = new TaskException(ex.getMessage(),
				ZonedDateTime.now(ZoneId.of("Z")),
				httpStatus,
				ex
				);
		return new ResponseEntity<>(t,httpStatus);
	}
}
