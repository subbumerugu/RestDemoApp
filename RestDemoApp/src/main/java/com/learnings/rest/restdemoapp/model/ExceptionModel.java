package com.learnings.rest.restdemoapp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExceptionModel {
	private String erroMessage;
	private int errorCode;
	public ExceptionModel(String erroMessage, int errorCode) {
		this.erroMessage = erroMessage;
		this.errorCode = errorCode;
	}
	public ExceptionModel() {
	}
	public String getErroMessage() {
		return erroMessage;
	}
	public void setErroMessage(String erroMessage) {
		this.erroMessage = erroMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	
}
