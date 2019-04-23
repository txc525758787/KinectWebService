package com.txc.kinect.server.controller;

import com.txc.kinect.server.model.User;
import com.txc.kinect.server.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
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

}
