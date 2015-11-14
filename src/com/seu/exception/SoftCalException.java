package com.seu.exception;

public class SoftCalException extends Exception {
	String errorMsg;
	int errorCode;
	
	public SoftCalException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
	public SoftCalException() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
