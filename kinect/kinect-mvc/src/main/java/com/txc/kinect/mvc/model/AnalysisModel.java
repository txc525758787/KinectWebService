package com.txc.kinect.mvc.model;

import java.math.BigDecimal;

public class AnalysisModel {
	private String actionType;
	private String times;
	private BigDecimal correctRate;
	public AnalysisModel(){

	}
	public AnalysisModel(String actionType, String times, BigDecimal correctRate) {
		this.actionType = actionType;
		this.times = times;
		this.correctRate = correctRate;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public BigDecimal getCorrectRate() {
		return correctRate;
	}

	public void setCorrectRate(BigDecimal correctRate) {
		this.correctRate = correctRate;
	}
}
