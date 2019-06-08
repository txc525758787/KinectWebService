package com.txc.kinect.server.controller;

import com.github.pagehelper.PageHelper;
import com.txc.kinect.mvc.controller.BaseController;
import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.mvc.model.PageInfo;
import com.txc.kinect.server.model.Action;
import com.txc.kinect.server.service.ActionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class ActionManagementController extends BaseController {

	@Resource
	ActionService actionService;


	@GetMapping("/actions")
	@ResponseBody
	public HttpResult getAllAction(@RequestParam int pageNum, @RequestParam int pageSize) {
		PageInfo<Action> pageInfo = new PageInfo<>();
		pageInfo.setTotal(actionService.getAllAction().size());
		PageHelper.startPage(pageNum, pageSize);
		pageInfo.setRows(actionService.getAllAction());
		return responseOK(pageInfo);
	}

	@GetMapping("/action/{id}")
	@ResponseBody
	public HttpResult getActionById(@PathVariable Integer id) {
		return responseOK(actionService.selectByKey(id));
	}

	@PostMapping("/action")
	@ResponseBody
	public HttpResult addAction(@RequestBody Action action) {
		actionService.insert(action);
		return responseOK();
	}

	@PutMapping("/action")
	@ResponseBody
	public HttpResult updateAction(@RequestBody Action action) {
		actionService.update(action);
		return responseOK();
	}

	@DeleteMapping("/action/{id}")
	@ResponseBody
	public HttpResult deleteActionById(@PathVariable Integer id) {
		actionService.deleteByKey(id);
		return responseOK();
	}

	@GetMapping("/action/list")
	public String toActionListPage(){
		return "action_list";
	}

	@GetMapping("/action/list/{id}")
	public String toActionInfoPage(){
		return "action_info";
	}
}
