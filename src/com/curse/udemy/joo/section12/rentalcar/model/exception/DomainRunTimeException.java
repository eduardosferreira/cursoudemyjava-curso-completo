package com.curse.udemy.joo.section12.rentalcar.model.exception;

public class DomainRunTimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DomainRunTimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DomainRunTimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public DomainRunTimeException(String message) {
		super(message);
	}

	public DomainRunTimeException(Throwable cause) {
		super(cause);
	}


	
}
