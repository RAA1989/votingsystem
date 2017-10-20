package com.projects.votingsystem.util.Exception;

//import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class ApplicationException extends RuntimeException {
    public static final String EXCEPTION_MODIFICATION_RESTRICTION = "exception.user.modificationRestriction";

    private final ErrorType type;
    private final String msgCode;
    //private final HttpStatus httpStatus;
    private final String[] args;

//    public ApplicationException(String msgCode, HttpStatus httpStatus) {
//        this(ErrorType.APP_ERROR, msgCode, httpStatus);
//    }

    public ApplicationException(String msgCode) {
        this(ErrorType.APP_ERROR, msgCode);
    }

    public ApplicationException(ErrorType type, String msgCode, String... args) {
        super(String.format("type=%s, msgCode=%s, args=%s", type, msgCode, Arrays.toString(args)));
        this.type = type;
        this.msgCode = msgCode;
        this.args = args;
    }

    public ErrorType getType() {
        return type;
    }

    public String getMsgCode() {
        return msgCode;
    }

//    public HttpStatus getHttpStatus() {
//        return httpStatus;
//    }

    public String[] getArgs() {
        return args;
    }

}