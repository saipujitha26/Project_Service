package com.cg.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ProjectAlreadyExistsException.class)
	public ResponseEntity<String> handleProjectAlreadyExistsException(ProjectAlreadyExistsException project){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(project.getMessage());
	}
	
	
	@ExceptionHandler(DBException.class)
	public ResponseEntity<String> handleDBException(DBException project){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(project.getMessage());
	}

	@ExceptionHandler(ProjectNotFoundException.class)
	public ResponseEntity<String> handleProjectNotFoundException(ProjectNotFoundException project){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(project.getMessage());
	}
}
