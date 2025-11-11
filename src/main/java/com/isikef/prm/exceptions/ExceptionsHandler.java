package com.isikef.prm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MissingEntityException.class)
    public ResponseEntity handleMissingEntityException(MissingEntityException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity handleConnectException(ConnectException exception){
        //TODO migrate to the send MYSQL server database
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Please, send this to the database administrator");
    }
}
