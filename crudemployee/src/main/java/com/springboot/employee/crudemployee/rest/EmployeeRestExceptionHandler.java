package com.springboot.employee.crudemployee.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

	// Add an exception handler for EmployeeNotFoundException
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
		
		// create a EmployeeErrorResponse		
		EmployeeErrorResponse error = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(), 
																exc.getMessage(), System.currentTimeMillis());		
		
		// return ResponseEntity		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	

	// Add another exception handle ... to catch any exception (catch all)	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){
		
		// create a EmployeeErrorResponse		
		EmployeeErrorResponse error = new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(), 
																exc.getMessage(), System.currentTimeMillis());	
		
		
		// return ResponseEntity		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
