package com.ltim.exception;

public class InvalidChoiceException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8639245723036881171L;
	private String message;

	public  InvalidChoiceException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;	
	}
}