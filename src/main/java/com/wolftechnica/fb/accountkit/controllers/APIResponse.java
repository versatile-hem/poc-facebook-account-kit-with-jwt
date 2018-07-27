package com.wolftechnica.fb.accountkit.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse {

	private boolean status;
	private long statusCode;
	private String message;
	private Object result;

	public APIResponse() {
	}

	public APIResponse(boolean status, long statusCode, String message, Object result) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.result = result;
	}

	public APIResponse(boolean status, long statusCode, String message) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(long statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
