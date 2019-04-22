package com.demo.controller.model;

public class Result {
	/**
	 * 传给前端的数据
	 */
	protected Object data;
	/**
	 * 状态码
	 */
	protected Integer code;
	/**
	 * 传给前端的信息
	 */
	protected String message;

	private Result(){

	}
	private Result(Integer code){
		this.code = code;
	}

	public static Result createResult(Integer code){
		return new Result(code);
	}

	public static Result createSuccessResult(){
		return new Result(ResultCode.SUCCESS);
	}

	public Object getData() {
		return data;
	}

	public Result setData(Object data) {
		this.data = data;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public Result setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Result setMessage(String message) {
		this.message = message;
		return this;
	}
}
