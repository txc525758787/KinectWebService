package com.demo.controller;

import com.demo.controller.model.Result;
import com.demo.model.User;
import com.demo.model.UserAuths;
import com.demo.provider.MD5Provider;
import com.demo.service.RegistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/register")
public class RegistController {

	@Resource
	RegistService registService;

	@PostMapping("/regist")
	public @ResponseBody
	Result userRegist(@RequestBody UserAuths register){
		registService.regist(register);
		return Result.createSuccessResult();
	}


}
