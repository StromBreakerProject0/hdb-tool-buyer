package com.hddtool.vo;

import org.springframework.lang.NonNull;

public class ApiResponse {

	private Object date;

	@NonNull
	private String message;

	public ApiResponse(Object date, @NonNull String message) {
		super();
		this.date = date;
		this.message = message;
	}

	public ApiResponse(@NonNull String message) {
		super();
		this.message = message;
	}

	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
