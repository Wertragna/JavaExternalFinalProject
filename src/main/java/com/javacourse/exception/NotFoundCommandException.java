package com.javacourse.exception;

public class NotFoundCommandException extends RuntimeException {
    public NotFoundCommandException() {
    }

    public NotFoundCommandException(String message) {
        super(message);
    }
}
