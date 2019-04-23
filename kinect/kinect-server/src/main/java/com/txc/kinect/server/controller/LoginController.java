package com.txc.kinect.server.controller;

import com.txc.kinect.mvc.model.Result;
import com.txc.kinect.server.model.UserAuths;
import com.txc.kinect.server.service.UserAuthsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource
	UserAuthsService userAuthsService;


	@GetMapping
	public String login(){
		return "login";
	}


	@PostMapping("/doLogin")
	public @ResponseBody
	Result doLogin(@RequestBody UserAuths userAuths){
		return userAuthsService.login(userAuths);
	}




}
