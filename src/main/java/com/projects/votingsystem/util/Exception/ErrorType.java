package com.projects.votingsystem.util.Exception;

public enum ErrorType {
    APP_ERROR("error.appError"),
    DATA_NOT_FOUND("error.dataNotFound"),
    TIME_EXPIRED("error.timeExpired"),
    DATA_ERROR("error.dataError"),
    VALIDATION_ERROR("error.validationError");

    private final String errorCode;

    ErrorType(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
