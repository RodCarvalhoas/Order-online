package com.order_online.user_service.domain.exception;

public class InvalidBalanceException extends RuntimeException {

    public InvalidBalanceException(String message) {
        super(message);
    }
}
