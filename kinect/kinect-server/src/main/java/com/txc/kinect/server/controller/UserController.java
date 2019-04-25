package com.txc.kinect.server.controller;

import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.server.model.User;
import com.txc.kinect.server.service.UserService;
import com.txc.kinect.server.session.SpringUtil;
import com.txc.kinect.server.session.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	UserService userService;

	@GetMapping("/get")
	public @ResponseBody
	User getUser(@RequestParam Integer key){
		return userService.selectByKey(key);
	}

	@GetMapping("/success")
	public String toSuccessPage(){
		return "test";
	}

	@GetMapping("/getSession")
	@ResponseBody
	public HttpResult getSession(){
		UserSession userSession = SpringUtil.getBean(UserSession.class);
		return responseOK(userSession.getUserId());
	}

}
