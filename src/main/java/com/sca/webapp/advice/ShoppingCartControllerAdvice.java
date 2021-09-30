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
    public ResponseEntity<String> noSuchElementNotFoundException(NoSuchElementException elementException){
        return new ResponseEntity<>("Sorry The Product is not available.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ProductNotFoundException.class, EntityNotFoundException.class})
    public ResponseEntity<String> productNotFoundException(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>(productNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
    }
}
