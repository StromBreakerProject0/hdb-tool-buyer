package com.hdbtool.vo;

import lombok.Data;
import lombok.NonNull;

@Data
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
    
    
}
