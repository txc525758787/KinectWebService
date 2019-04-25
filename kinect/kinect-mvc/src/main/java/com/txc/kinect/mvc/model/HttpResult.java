package com.txc.kinect.mvc.model;

public class HttpResult {
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

	private HttpResult() {

	}

	private HttpResult(Integer code) {
		this.code = code;
	}

	private static HttpResult createResult(Integer code) {
		return new HttpResult(code);
	}

	public static HttpResult createSuccessResult() {
		return createResult(HttpResultCode.SUCCESS);
	}

	public static HttpResult createSuccessResult(Object data) {
		return createSuccessResult().setData(data);
	}

	public static HttpResult createFailResult(int code){
		return createResult(code);
	}

	public static HttpResult createFailResult(String message){return new HttpResult().setMessage(message);}

	public static HttpResult createFailResult(int code, String message){
		return createFailResult(code).setMessage(message);
	}


	public Object getData() {
		return data;
	}

	public HttpResult setData(Object data) {
		this.data = data;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public HttpResult setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public HttpResult setMessage(String message) {
		this.message = message;
		return this;
	}
}
