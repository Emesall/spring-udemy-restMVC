package com.emesall.restmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.emesall.restmvc.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	 @ExceptionHandler({ResourceNotFoundException.class})
	public ResponseEntity<Object> handleNotFoundException(Exception ex){
		
		return new ResponseEntity<Object>("Resource Not Found",new HttpHeaders(),HttpStatus.NOT_FOUND);
	}

}
