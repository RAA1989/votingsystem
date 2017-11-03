package com.projects.votingsystem.util.Exception;


public class TimeOutOfBoundsException extends ApplicationException {
    public static final String TIME_EXPIRED = "exception.common.outOfBounds";

    public TimeOutOfBoundsException(String arg) {
        super(ErrorType.TIME_EXPIRED, TIME_EXPIRED, arg);
    }
}
