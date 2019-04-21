package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	UserService userService;

	@GetMapping("/get")
	public @ResponseBody User getUser(@RequestParam Integer key){
		return userService.selectByKey(key);
	}

}
