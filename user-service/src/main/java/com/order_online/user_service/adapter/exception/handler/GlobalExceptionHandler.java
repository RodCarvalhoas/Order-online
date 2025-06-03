package com.order_online.user_service.adapter.exception.handler;

import com.order_online.user_service.adapter.exception.handler.response.ExceptionResponse;
import com.order_online.user_service.domain.exception.InvalidBalanceException;
import com.order_online.user_service.domain.exception.InvalidCredentialsException;
import com.order_online.user_service.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Object> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        var exception = new ExceptionResponse(HttpStatus.UNAUTHORIZED, ex);
        return buildResponseEntity(exception, ex);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleInvalidCredentialsException(UserNotFoundException ex) {
        var exception = new ExceptionResponse(HttpStatus.NOT_FOUND, ex);
        return buildResponseEntity(exception, ex);
    }

    @ExceptionHandler(InvalidBalanceException.class)
    public ResponseEntity<Object> handleInvalidCredentialsException(InvalidBalanceException ex) {
        var exception = new ExceptionResponse(HttpStatus.BAD_REQUEST, ex);
        return buildResponseEntity(exception, ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        var exception = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
        return buildResponseEntity(exception, ex);
    }

    private ResponseEntity<Object> buildResponseEntity(ExceptionResponse exResponse, Exception ex) {
        return new ResponseEntity<>(exResponse, exResponse.getStatus());
    }
}
