package com.txc.kinect.server.controller;

import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.server.model.UserAuths;
import com.txc.kinect.server.service.UserAuthsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Resource
	UserAuthsService userAuthsService;


	@GetMapping
	public String login(){
		return "login";
	}


	@PostMapping("/doLogin")
	public @ResponseBody
	HttpResult doLogin(@RequestBody UserAuths userAuths){
		return null;
	}




}
