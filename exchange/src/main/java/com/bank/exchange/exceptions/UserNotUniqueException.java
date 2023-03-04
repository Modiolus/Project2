package com.bank.exchange.exceptions;

public class UserNotUniqueException extends RuntimeException{
    public UserNotUniqueException(String message) {
        super(message);
    }
}
