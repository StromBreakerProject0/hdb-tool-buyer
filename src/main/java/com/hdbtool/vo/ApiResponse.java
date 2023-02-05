package com.hdbtool.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
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
