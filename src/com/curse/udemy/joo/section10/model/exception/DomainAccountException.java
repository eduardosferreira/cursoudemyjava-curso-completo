package com.curse.udemy.joo.section10.model.exception;

public class DomainAccountException extends Exception {
	private static final long serialVersionUID = 1L;


	public DomainAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DomainAccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public DomainAccountException(String message) {
		super(message);
	}

	public DomainAccountException(Throwable cause) {
		super(cause);
	}

	
}
