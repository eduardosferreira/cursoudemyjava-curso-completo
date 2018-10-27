package com.curse.udemy.joo.section10.model.exception;

public class DomainReservationException extends Exception {
	private static final long serialVersionUID = 1L;


	public DomainReservationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DomainReservationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DomainReservationException(String message) {
		super(message);
	}

	public DomainReservationException(Throwable cause) {
		super(cause);
	}

	
}
