package com.sca.webapp.advice;

import com.sca.webapp.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ShoppingCartControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> noSuchElementNotFoundException(NoSuchElementException elementException){
        return new ResponseEntity<>("Sorry The Product is not available.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotFoundException(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<String>("Sorry! The Product which you are looking is Not Available",HttpStatus.NOT_FOUND);
    }
}
