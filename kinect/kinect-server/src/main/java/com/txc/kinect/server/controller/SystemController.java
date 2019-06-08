package com.txc.kinect.server.controller;

import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.server.service.SendVerificationService;
import com.txc.kinect.server.session.UserSession;
import com.txc.kinect.server.utils.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class SystemController extends BaseController {

	@Resource
	SendVerificationService sendVerificationService;


	@GetMapping("/vCode")
	@ResponseBody
	public HttpResult sendVerificationCode(HttpSession httpSession) {
		String identity = ((UserSession) httpSession.getAttribute("userSession")).getIdentity();
		Integer verificationCode = MessageUtils.getRadomVerifictionCode();
		sendVerificationService.sendVerificationCode(identity, MessageUtils.createMessage(verificationCode));
		httpSession.setAttribute("verification", verificationCode);
		return responseOK();
	}

	@GetMapping("/vCode/{identity}")
	@ResponseBody
	public HttpResult sendVerificationCode(@PathVariable String identity, HttpSession httpSession) {
		Integer verificationCode = MessageUtils.getRadomVerifictionCode();
		sendVerificationService.sendVerificationCode(identity, MessageUtils.createMessage(verificationCode));
		httpSession.setAttribute("verification", verificationCode);
		return responseOK();
	}

	@PostMapping("/verify")
	public HttpResult verify(@RequestParam Integer verification, HttpSession httpSession) {
		if (sendVerificationService.verify(verification, httpSession)) {
			return responseOK();
		}
		return responseFail("验证码错误");
	}

	@GetMapping("/index")
	public String toIndexPage() {
		return "test_index";
	}

}
