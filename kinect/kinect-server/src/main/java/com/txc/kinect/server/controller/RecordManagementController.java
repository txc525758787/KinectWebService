package com.txc.kinect.server.controller;

import com.github.pagehelper.PageHelper;
import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.mvc.model.PageInfo;
import com.txc.kinect.server.model.UserRecord;
import com.txc.kinect.server.service.AnalysisService;
import com.txc.kinect.server.service.UserRecordService;
import com.txc.kinect.server.session.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class RecordManagementController extends BaseController {

	@Resource
	UserRecordService userRecordService;
	@Resource
	AnalysisService analysisService;

	@GetMapping("/records")
	@ResponseBody
	public HttpResult getRecords(@RequestParam int pageNum, @RequestParam int pageSize, HttpSession httpSession) {
		PageInfo<UserRecord> pageInfo = new PageInfo<>();
		Integer userId = ((UserSession) httpSession.getAttribute("userSession")).getUserId();
		pageInfo.setTotal(userRecordService.getRecordsByUserId(userId).size());
		PageHelper.startPage(pageNum, pageSize);
		pageInfo.setRows(userRecordService.getRecordsByUserId(userId));
		return responseOK(pageInfo);
	}

	@PostMapping("/record")
	@ResponseBody
	public HttpResult addRecord(@RequestBody UserRecord userRecord) {
		userRecordService.insert(userRecord);
		return responseOK();
	}

	@GetMapping("/analysis")
	@ResponseBody
	public HttpResult getRecentAnalysis(HttpSession httpSession) {
		return responseOK(analysisService.getRecentAnalysis(
				((UserSession) httpSession.getAttribute("userSession")).getUserId()));
	}
}
