package com.txc.kinect.server.controller;

import com.github.pagehelper.PageHelper;

import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.mvc.model.PageInfo;
import com.txc.kinect.server.model.UserRecord;
import com.txc.kinect.server.service.UserRecordService;
import com.txc.kinect.server.session.SpringUtil;
import com.txc.kinect.server.session.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/records")
public class UserRecordController extends BaseController {

	@Resource
	UserRecordService userRecordService;

	@PostMapping("/insert")
	@ResponseBody
	public HttpResult insert(@RequestBody UserRecord userRecord){
		userRecord.setStartTime(new Date());
		userRecord.setEndTime(new Date());
		userRecord.setIsCorrect(1);
		userRecordService.insert(userRecord);
		return responseOK();
	}

	@GetMapping("/getRecords")
	@ResponseBody
	public HttpResult getRecords(@RequestParam int pageNum, @RequestParam int pageSize){
		//SpringUtil.getBean(UserSession.class).getUserId()

		PageInfo<UserRecord> pageInfo = new PageInfo<>();
		pageInfo.setDataLength(userRecordService.findRecordsByUserId(SpringUtil.getBean(UserSession.class).getUserId()).size());
		PageHelper.startPage(pageNum,pageSize);
		List<UserRecord> records = userRecordService.findRecordsByUserId(SpringUtil.getBean(UserSession.class).getUserId());
		pageInfo.setList(records);
		return responseOK(pageInfo);
	}
}
