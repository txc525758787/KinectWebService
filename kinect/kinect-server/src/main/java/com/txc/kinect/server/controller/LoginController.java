package com.txc.kinect.server.controller;

import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.server.session.UserSession;
import com.txc.kinect.mvc.provider.MD5Provider;
import com.txc.kinect.server.model.UserAuths;
import com.txc.kinect.server.service.UserAuthsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Resource
	UserAuthsService userAuthsService;
	@Autowired
	UserSession userSession;


	@GetMapping
	public String login(){
		return "index";
	}


	@PostMapping("/doLogin")
	public @ResponseBody
	HttpResult doLogin(@RequestBody UserAuths auths){
		UserAuths userAuths = userAuthsService.selectByIdentity(auths.getIdentity());
		if(userAuths == null){
			return responseFail("此用户不存在");
		}else if(userAuths.getIsEnable() == 0){
			return responseFail("此用户已被禁用");
		}else if(!userAuths.getCredential().equals(MD5Provider.encrypt(auths.getCredential()))){
			return responseFail("用户名或密码错误");
		}
		//更新最近登录时间
		userAuths.setLastLoginTime(new Date());
		userAuthsService.update(userAuths);
		//设置一个usesession(userId,identity)
		userSession.setIdentity(userAuths.getIdentity());
		userSession.setUserId(userAuths.getUserId());
		return responseOK();
	}




}
