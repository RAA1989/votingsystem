package com.projects.votingsystem.util.Exception;


import org.springframework.http.HttpStatus;

public class TimeOutOfBoundsException extends ApplicationException {

    public TimeOutOfBoundsException(String arg) {
        super(ErrorType.TIME_EXPIRED, HttpStatus.BAD_REQUEST, arg);
    }
}
