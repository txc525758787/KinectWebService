package com.txc.kinect.server.controller;

import com.github.pagehelper.PageHelper;
import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpCode;
import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.mvc.model.PageInfo;
import com.txc.kinect.mvc.model.RegisterDTO;
import com.txc.kinect.server.model.User;
import com.txc.kinect.server.model.UserAuth;
import com.txc.kinect.server.provider.PasswordProvider;
import com.txc.kinect.server.service.UserAuthService;
import com.txc.kinect.server.service.UserService;
import com.txc.kinect.server.session.UserSession;
import com.txc.kinect.server.utils.IdentityUtils;
import com.txc.kinect.server.utils.IpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class UserManagementController extends BaseController {

	@Resource
	UserAuthService userAuthService;

	@Resource
	UserService userService;

	/**
	 * 开启回话/登录
	 *
	 * @param identity
	 * @param credential
	 * @param httpSession
	 * @param httpServletRequest
	 * @return
	 */
	@PostMapping("/session")
	@ResponseBody
	public HttpResult login(@RequestParam String identity,
							@RequestParam String credential,
							HttpSession httpSession,
							HttpServletRequest httpServletRequest) {

		UserAuth userAuth = userAuthService.selectByKey(identity);
		if (userAuth == null) {
			return responseFail(HttpCode.LOGIN_FAIL, "此用户不存在");
		} else if (userAuth.getIsEnable() == 1) {
			return responseFail(HttpCode.LOGIN_FAIL, "此用户已被禁用");
		} else if (!userAuth.getCredential().equals(PasswordProvider.encrypt(credential))) {
			return responseFail(HttpCode.LOGIN_FAIL, "用户名或密码错误");
		}
		//获取本次登录IP地址
		String loginIpAddr = IpUtils.getIpAddr(httpServletRequest);
		if (!loginIpAddr.equals(userAuth.getLastLoginIp())) {
			return responseFail(HttpCode.IP_CHANGED, "IP地址变更");
		}
		//更新最近登录时间
		userAuth.setLastLoginTime(new Date());
		userAuthService.update(userAuth);
		//设置一个UserSession(userId,identity)
		UserSession userSession =
				new UserSession(userAuth.getUserId(), userAuth.getIdentity());
		httpSession.setAttribute("userSession", userSession);
		Integer roleId = userService.selectByKey(userAuth.getUserId()).getRoleId();
		return responseOK(roleId);
	}

	/**
	 * 注册
	 *
	 * @param register
	 * @param httpSession
	 * @return
	 */
	@PostMapping("/user")
	@ResponseBody
	public HttpResult register(@RequestBody RegisterDTO register, HttpSession httpSession) {
		if (!(register.getVerification()).equals(httpSession.getAttribute("verification"))) {
			return responseFail("验证码错误");
		}
		if (null != userAuthService.selectByKey(register.getIdentity())) {
			return responseFail("用户名已存在");
		}
		//创建一个默认user
		User defaultUser = userService.createDefaultUser(register.getIdentity());
		//装配一个userAuth存入表中
		UserAuth userAuth = new UserAuth();
		userAuth.setUserId(defaultUser.getId());
		userAuth.setIdentityType(register.getIdentityType());
		userAuth.setIdentity(register.getIdentity());
		userAuth.setCredential(PasswordProvider.encrypt(register.getCredential()));
		userAuth.setCreateTime(new Date());
		userAuthService.insert(userAuth);
		return responseOK();
	}

	/**
	 * 注销
	 *
	 * @param httpSession
	 * @return
	 */
	@DeleteMapping("/session")
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("userSession");
		return "redirect:/index";
	}

	/**
	 * 账号绑定
	 *
	 * @param verification
	 * @param bindIdentity
	 * @param httpSession
	 * @return
	 */
	@PostMapping("/bind")
	@ResponseBody
	public HttpResult bind(@RequestParam Integer verification,
						   @RequestParam String bindIdentity,
						   HttpSession httpSession) {
		if (!verification.equals(httpSession.getAttribute("verification"))) {
			return responseFail("验证码错误");
		}
		if (null != userAuthService.selectByKey(bindIdentity)) {
			return responseFail("账号已被注册或绑定");
		}
		UserAuth loginUserAuth = userAuthService
				.selectByKey(((UserSession) httpSession.getAttribute("userSession")).getIdentity());
		UserAuth bindAuth = new UserAuth();
		bindAuth.setIdentity(bindIdentity);
		bindAuth.setIdentityType(IdentityUtils.getType(bindIdentity));
		bindAuth.setCredential(loginUserAuth.getCredential());
		bindAuth.setCreateTime(new Date());
		bindAuth.setUserId(loginUserAuth.getUserId());
		userAuthService.insert(bindAuth);
		return responseOK();
	}

	/**
	 * 修改登录用户信息
	 * @param user
	 * @param httpSession
	 * @return
	 */
	@PutMapping("/user")
	@ResponseBody
	public HttpResult upDateUser(@RequestBody User user, HttpSession httpSession) {
		User loginUser = userService
				.selectByKey(((UserSession) httpSession.getAttribute("userSession")).getUserId());
		userService.update(changeInfo(loginUser, user));
		return responseOK();
	}

	@GetMapping("/users")
	@ResponseBody
	public HttpResult getAllUser(@RequestParam int pageNum, @RequestParam int pageSize) {
		PageInfo<User> pageInfo = new PageInfo<>();
		pageInfo.setTotal(userService.getAllUser().size());
		PageHelper.startPage(pageNum,pageSize);
		pageInfo.setRows(userService.getAllUser());
		return responseOK(pageInfo);
	}

	@GetMapping("/user/{id}")
	@ResponseBody
	public HttpResult getUserById(@PathVariable Integer id) {
		return responseOK(userService.selectByKey(id));
	}

	@GetMapping("/login")
	public String toLoginPage() {
		return "test_login";
	}

	@GetMapping("/sign-up")
	public String toRegisterPage() {
		return "sign_up";
	}

	@GetMapping("/profile")
	public String toProfilePage() {
		return "profile";
	}

	/**
	 * 更新LoginUser的信息
	 * @param loginUser
	 * @param infoUser
	 * @return
	 */
	private User changeInfo(User loginUser, User infoUser) {
		if (null != infoUser.getNickname()) {
			loginUser.setNickname(infoUser.getNickname());
		}else if(null != infoUser.getBirthday()) {
			loginUser.setBirthday(infoUser.getBirthday());
		}else if(null != infoUser.getAvatar()) {
			loginUser.setAvatar(infoUser.getAvatar());
		}else if(null != infoUser.getIntroduction()) {
			loginUser.setIntroduction(infoUser.getIntroduction());
		}else if(null != infoUser.getRoleId()) {
			loginUser.setRoleId(infoUser.getRoleId());
		}
		return loginUser;
	}

}
