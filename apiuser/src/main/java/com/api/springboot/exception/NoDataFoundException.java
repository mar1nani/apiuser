package com.api.springboot.exception;

import com.api.springboot.constant.Constant;

public class NoDataFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NoDataFoundException() {

        super(Constant.NoDataFoundExceptionMessage);
    }
}
