package com.app.exception;

public class ApplicationException extends Exception {

	private String message;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
