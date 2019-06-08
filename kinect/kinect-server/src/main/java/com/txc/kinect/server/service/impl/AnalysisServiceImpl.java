package com.txc.kinect.server.service.impl;

import com.txc.kinect.mvc.model.AnalysisModel;
import com.txc.kinect.server.model.UserRecord;
import com.txc.kinect.server.service.AnalysisService;
import com.txc.kinect.server.service.UserRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

	@Resource
	UserRecordService userRecordService;

	@Override
	public List<AnalysisModel> getRecentAnalysis(Integer userId) {
		return null;
	}
}
