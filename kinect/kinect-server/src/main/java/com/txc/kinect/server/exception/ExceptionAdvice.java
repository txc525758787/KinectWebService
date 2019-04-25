package com.txc.kinect.server.exception;

import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.exception.MapperException;
import com.txc.kinect.mvc.model.HttpResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一异常处理
 */
@ControllerAdvice
@RestController
public class ExceptionAdvice extends BaseController {
	@ExceptionHandler(MapperException.class)
	protected HttpResult mapperException(MapperException e){
		return responseFail(e.getCode(), e.getMessage());
	}
}
