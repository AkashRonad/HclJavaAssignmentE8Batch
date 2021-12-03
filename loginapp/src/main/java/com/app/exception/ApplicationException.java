package com.app.exception;

public class ApplicationException extends Exception {

	public String message;

	public ApplicationException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {

		return this.message;
	}

}
