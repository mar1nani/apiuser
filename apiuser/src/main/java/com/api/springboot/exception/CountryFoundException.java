package com.api.springboot.exception;

public class CountryFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CountryFoundException() {

        super("No data found");
    }
}
