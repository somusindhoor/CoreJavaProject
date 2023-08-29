package com.customException;

public class ProductNotFoundException extends RuntimeException {
	private String message;

	public ProductNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;		
	}
}
