package com.hcl.exception;

public class AppliactionException extends Exception {

	private String message;

	public AppliactionException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {

		return this.message;
	}

}
