package com.txc.kinect.server.service;

import com.txc.kinect.mvc.model.AnalysisModel;

import java.util.List;

public interface AnalysisService {

	public List<AnalysisModel> getRecentAnalysis(Integer userId);

}
