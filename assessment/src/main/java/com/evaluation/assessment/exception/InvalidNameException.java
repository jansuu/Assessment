package com.evaluation.assessment.exception;

public class InvalidNameException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private String message;

	public InvalidNameException(String message) 
	{
		super();
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	} 

}
