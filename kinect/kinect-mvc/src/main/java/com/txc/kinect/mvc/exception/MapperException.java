package com.txc.kinect.mvc.exception;

import com.txc.kinect.mvc.model.HttpCode;


public class MapperException extends RuntimeException{

	private static final long serialVersionUID = 1;

	public static final String MESSAGE = "数据库访问异常";

	private int code = HttpCode.DATA_ACCESS_ERROR;

	public MapperException(){
		super(MESSAGE);
	}

	public MapperException(String message){
		super(message);
	}

	public MapperException(int code, String message){
		super(message);
		this.code = code;
	}

	public MapperException(String message, Throwable cause) {
		super(message, cause);
	}

	public MapperException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public MapperException(Throwable cause) {
		super(cause);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
