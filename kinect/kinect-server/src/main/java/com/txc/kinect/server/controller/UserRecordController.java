package com.txc.kinect.server.controller;

import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpResult;
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
	public HttpResult getRecords(){
		List<UserRecord> records = userRecordService.findRecordsByUserId(SpringUtil.getBean(UserSession.class).getUserId());
		return responseOK(records);
	}
}
