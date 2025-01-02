package com.bank.project.exception;

import org.springframework.http.HttpStatus;

public class AccountHandleException extends RuntimeException{

	
	private HttpStatus status;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountHandleException() {
		super();
	}

	public AccountHandleException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccountHandleException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountHandleException(String message) {
		super(message);
	}

	public AccountHandleException(Throwable cause) {
		super(cause);
	}
	
	public AccountHandleException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	
}
