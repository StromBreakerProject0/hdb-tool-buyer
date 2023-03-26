package com.hdbtool.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException{

    private static final long serialVersionUID = -4805738974378459091L;

	public ApiException(String e){
        super(e);
    }

    private String errorCode;
    private String errorMessage;
    private String errorDescription;
    private int status;

    public ApiException(){
        super();
    }

    public ApiException(String errorCode, String errorMessage){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ApiException(String errorCode, String errorMessage, int status){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public ApiException(String errorCode, String errorMessage, String errorDescription){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }

}
