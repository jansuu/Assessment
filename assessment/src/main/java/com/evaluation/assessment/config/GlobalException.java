package com.evaluation.assessment.config;

import java.io.IOException;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.evaluation.assessment.exception.InvalidIDException;
import com.evaluation.assessment.exception.InvalidNameException;

@RestControllerAdvice
public class GlobalException 
{
	@ExceptionHandler(InvalidIDException.class)
	public ErrorResponse invalidIDException(InvalidIDException e)
	{
		return ErrorResponse.create(e, 
				HttpStatusCode.valueOf(400), 
				e.getMessage());
	}
	
	@ExceptionHandler(InvalidNameException.class)
	public ErrorResponse InvalidNameException(InvalidNameException e)
	{
		return ErrorResponse.create(e, 
				HttpStatusCode.valueOf(400), 
				e.getMessage());
	}
	
	 @ExceptionHandler(IOException.class)
 	 public ErrorResponse invalidIOExceptionHandler(IOException e) 
 	 {
 		 return ErrorResponse.create
 				 			(e, 
 				 			HttpStatusCode.valueOf(400), 
 				 			e.getMessage()); 
 	 }
 	 
 	 @ExceptionHandler(Exception.class)
	 public ErrorResponse exceptionHandler(Exception e)
 	 {
		 return ErrorResponse.create
				 			(e, 
				 			HttpStatusCode.valueOf(400), 
				 			e.getMessage()); 
	 }

}
