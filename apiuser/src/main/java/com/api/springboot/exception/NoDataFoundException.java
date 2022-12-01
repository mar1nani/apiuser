package com.api.springboot.exception;

public class NoDataFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NoDataFoundException() {

        super("Country must be french");
    }
}
