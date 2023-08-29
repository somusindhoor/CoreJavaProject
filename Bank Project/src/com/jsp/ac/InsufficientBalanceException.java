package com.jsp.ac;

public class InsufficientBalanceException extends RuntimeException 
{
	private String message;

	public InsufficientBalanceException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
