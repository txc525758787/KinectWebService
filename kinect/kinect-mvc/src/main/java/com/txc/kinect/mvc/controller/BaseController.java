package com.txc.kinect.mvc.controller;

import com.txc.kinect.mvc.model.HttpResult;

public abstract class BaseController {

	protected HttpResult responseOK() {
		return HttpResult.createSuccessResult();
	}

	protected HttpResult responseOK(Object data) {
		return HttpResult.createSuccessResult(data);
	}

	protected HttpResult responseFail(int code) {
		return HttpResult.createFailResult(code);
	}

	protected HttpResult responseFail(String message) {
		return HttpResult.createFailResult(message);
	}


	protected HttpResult responseFail(int code, String message) {
		return HttpResult.createFailResult(code, message);
	}

}
