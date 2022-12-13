package com.api.springboot.exception;

import com.api.springboot.constant.Constant;

public class CountryFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CountryFoundException() {

        super(Constant.CountryFoundExceptionMessage);
    }
}
