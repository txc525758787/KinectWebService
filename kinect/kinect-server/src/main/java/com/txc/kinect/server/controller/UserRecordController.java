package com.txc.kinect.server.controller;

import com.github.pagehelper.PageHelper;
import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.mvc.model.PageInfo;
import com.txc.kinect.mvc.model.RecordDTO;
import com.txc.kinect.mvc.utils.DateUtils;
import com.txc.kinect.server.model.Action;
import com.txc.kinect.server.model.UserRecord;
import com.txc.kinect.server.service.ActionService;
import com.txc.kinect.server.service.UserRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/records")
public class UserRecordController extends BaseController {

	@Resource
	UserRecordService userRecordService;
	@Resource
	ActionService actionService;

	@PostMapping("/insert")
	@ResponseBody
	public HttpResult insert(@RequestBody UserRecord userRecord) {
//		userRecord.setStartTime(userRecord.getStartTime());
//		userRecord.setEndTime(userRecord.getEndTime());
//		userRecord.setIsCorrect(1);
		userRecordService.insert(userRecord);
		return responseOK();
	}

	@GetMapping("/getRecords")
	@ResponseBody
	public HttpResult getRecords(@RequestParam int pageNum, @RequestParam int pageSize, HttpSession httpSession) {
		//SpringUtil.getBean(UserSession.class).getUserId()
		System.out.print(httpSession.getAttribute("userId").toString());
		PageInfo<RecordDTO> pageInfo = new PageInfo<>();
		pageInfo.setTotal(userRecordService.getRecordsByUserId((Integer) httpSession.getAttribute("userId")).size());
		PageHelper.startPage(pageNum, pageSize);
		List<UserRecord> records = userRecordService.getRecordsByUserId((Integer) httpSession.getAttribute("userId"));
		pageInfo.setRows(covertRecordsToDTO(records));
		return responseOK(pageInfo);
	}

	private List<RecordDTO> covertRecordsToDTO(List<UserRecord> records) {
		List<RecordDTO> recordsDTO = new ArrayList();
		RecordDTO tempModel = new RecordDTO();
		for (UserRecord record : records) {
			Action action = actionService.selectByKey(record.getActionId());
			tempModel.setActionName(action.getActionName());
			tempModel.setActionType(action.getActionType());
			tempModel.setStartTime(DateUtils.format(record.getStartTime()));
			tempModel.setEndTime(DateUtils.format(record.getEndTime()));
			tempModel.setCorrectRate(record.getCorrectRate());
			recordsDTO.add(tempModel);
		}
		return recordsDTO;
	}

}
