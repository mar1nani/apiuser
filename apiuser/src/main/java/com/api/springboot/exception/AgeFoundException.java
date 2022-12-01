package com.api.springboot.exception;

public class AgeFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public AgeFoundException() {

        super("Age must be greater than 18");
    }
}
