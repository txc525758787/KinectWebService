package com.txc.kinect.server.controller;

import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.mvc.model.RegisterDTO;
import com.txc.kinect.mvc.provider.MD5Provider;
import com.txc.kinect.server.model.User;
import com.txc.kinect.server.model.UserAuths;
import com.txc.kinect.server.service.UserAuthsService;
import com.txc.kinect.server.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.lang.ref.PhantomReference;
import java.util.Date;

@Controller
@RequestMapping("/register")
public class RegistController extends BaseController {

	private static final String EMAIL = "email";
	private static final String PHONE = "phone";

	@Resource
	UserAuthsService userAuthsService;
	@Resource
	UserService userService;

	@PostMapping("/regist")
	public @ResponseBody
	HttpResult userRegist(@RequestBody RegisterDTO register){
		if(register.getIdentityType().equals(EMAIL)||register.getIdentityType().equals(PHONE)){
			if(register.getVerification()!=123456){//默认验证码 扩展时将其改成获取邮箱
				return responseFail("验证码错误");
			}
			if(null!=userAuthsService.selectByIdentity(register.getIdentity())){
				return responseFail("用户已存在");
			}
			//创建一个默认user并返回
			User newCreateUser = userService.createDefaultUser(register.getIdentity());
			//process userAuths
			UserAuths userAuths = new UserAuths();
			userAuths.setUserId(newCreateUser.getId());
			userAuths.setIdentityType(register.getIdentityType());
			userAuths.setIdentity(register.getIdentity());
			userAuths.setCredential(MD5Provider.encrypt(register.getCredential()));
			userAuths.setCreateTime(new Date());
			userAuthsService.insert(userAuths);
			return responseOK();
		}
		return  responseFail("非法账户类型");
	}

}
