package com.txc.kinect.mvc.model;

import java.math.BigDecimal;
import java.util.Date;

public class RecordDTO {

	private String actionName;

	private String actionType;

	private String startTime;

	private String endTime;

	private BigDecimal correctRate;

	public RecordDTO(){}

	public RecordDTO(String actionName, String actionType, String startTime, String endTime, BigDecimal correctRate) {
		this.actionName = actionName;
		this.actionType = actionType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.correctRate = correctRate;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getCorrectRate() {
		return correctRate;
	}

	public void setCorrectRate(BigDecimal correctRate) {
		this.correctRate = correctRate;
	}
}
