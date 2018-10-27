package com.curse.udemy.joo.section10.model.exception;

public class DomainReservationRunTimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DomainReservationRunTimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DomainReservationRunTimeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DomainReservationRunTimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DomainReservationRunTimeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


	
}
