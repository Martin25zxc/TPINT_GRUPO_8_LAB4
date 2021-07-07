package com.integrador.model;

public class AlertMessage {
	public String type;
	public String message;

	public AlertMessage(String type, String message) {
		this.type = type;
		this.message = message;
	}
	
	public AlertMessage() {
		this("","");
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
