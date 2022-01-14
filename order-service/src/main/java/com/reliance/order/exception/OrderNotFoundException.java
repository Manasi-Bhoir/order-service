package com.reliance.order.exception;

public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public OrderNotFoundException(String message) {
		super(message);
	}

	public OrderNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
