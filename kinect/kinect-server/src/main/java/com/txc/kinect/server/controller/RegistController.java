package com.txc.kinect.server.controller;

import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.server.model.UserAuths;
import com.txc.kinect.server.service.RegistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/register")
public class RegistController {

	@Resource
	RegistService registService;

	@PostMapping("/regist")
	public @ResponseBody
	HttpResult userRegist(@RequestBody UserAuths register){
		registService.regist(register);
		return HttpResult.createSuccessResult();
	}


}
