package com.javacourse.exception;

public class UnsupportedDaoOperationException extends UnsupportedOperationException{
    public UnsupportedDaoOperationException() {
    }

    public UnsupportedDaoOperationException(String message) {
        super(message);
    }
}
