package com.Exception;

public class InvalidQuantityException extends RuntimeException {
	private String message;

	public InvalidQuantityException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
