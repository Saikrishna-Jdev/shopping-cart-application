package com.sca.webapp.exception;

public class EmptyInputFieldException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public EmptyInputFieldException(String message) {
        super(message);

    }

    public EmptyInputFieldException() {
    }
}
