package com.evaluation.assessment.exception;

public class InvalidIDException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private String message;

	public InvalidIDException(String message) 
	{
		super();
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	} 

}
