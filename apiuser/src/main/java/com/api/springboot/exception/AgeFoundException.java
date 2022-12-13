package com.api.springboot.exception;

import com.api.springboot.constant.Constant;

public class AgeFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public AgeFoundException() {

        super(Constant.AgeFoundExceptionMessage);
    }
}
