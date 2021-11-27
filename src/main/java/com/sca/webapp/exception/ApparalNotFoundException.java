package com.sca.webapp.exception;

public class ApparalNotFoundException extends RuntimeException{

    public ApparalNotFoundException() {
    }

    public ApparalNotFoundException(String message) {
        super(message);
    }
}
