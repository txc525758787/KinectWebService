package com.demo.controller;

import com.demo.controller.model.Result;
import com.demo.model.UserAuths;
import com.demo.service.UserAuthsService;
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
