package com.bank.project.exception;

import org.springframework.http.HttpStatus;

public class CustomerHandleException extends RuntimeException{
	private HttpStatus status;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerHandleException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerHandleException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerHandleException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerHandleException(String message) {
		super(message);
	}

	public CustomerHandleException(Throwable cause) {
		super(cause);
	}
	
	public CustomerHandleException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	

}
