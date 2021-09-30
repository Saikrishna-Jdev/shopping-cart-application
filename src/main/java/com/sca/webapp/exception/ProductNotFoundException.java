package com.sca.webapp.exception;

public class ProductNotFoundException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public ProductNotFoundException(String errorCode,String errorMessage){
        super();
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
    public ProductNotFoundException(){

    }

    public ProductNotFoundException(String message){
        super(message);
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
}
