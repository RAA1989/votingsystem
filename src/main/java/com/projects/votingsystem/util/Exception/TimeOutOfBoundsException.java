package com.projects.votingsystem.util.Exception;


import org.springframework.http.HttpStatus;

public class TimeOutOfBoundsException extends ApplicationException {
    public static final String TIME_EXPIRED = "exception.common.outOfBounds";

    public TimeOutOfBoundsException(String arg) {
        super(ErrorType.TIME_EXPIRED, TIME_EXPIRED, HttpStatus.BAD_REQUEST, arg);
    }
}
