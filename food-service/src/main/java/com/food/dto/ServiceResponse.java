package com.food.dto;

public class ServiceResponse {
	
	private Integer maxSatisfaction;
	private String errorCode;
	private String errorDesc;
	public Integer getMaxSatisfaction() {
		return maxSatisfaction;
	}
	public void setMaxSatisfaction(Integer maxSatisfaction) {
		this.maxSatisfaction = maxSatisfaction;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

}
