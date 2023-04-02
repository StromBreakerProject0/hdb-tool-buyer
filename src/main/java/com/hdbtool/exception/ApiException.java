package com.hdbtool.exception;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = -4805738974378459091L;

	public ApiException(String e) {
		super(e);
	}

	private String errorCode;
	private String errorMessage;
	private String errorDescription;
	private int status;

	public ApiException() {
		super();
	}

	public ApiException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ApiException(String errorCode, String errorMessage, int status) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.status = status;
	}

	public ApiException(String errorCode, String errorMessage, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorDescription = errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
