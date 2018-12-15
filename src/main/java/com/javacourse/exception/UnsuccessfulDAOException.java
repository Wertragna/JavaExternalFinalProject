package com.javacourse.exception;

public class UnsuccessfulDAOException extends Exception {

    public UnsuccessfulDAOException() {
    }

    public UnsuccessfulDAOException(String message) {
        super(message);
    }
}
