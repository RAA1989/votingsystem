package com.projects.votingsystem.util.Exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApplicationException {
      //http://stackoverflow.com/a/22358422/548473
    public NotFoundException(String arg) {
        super(ErrorType.DATA_NOT_FOUND, HttpStatus.UNPROCESSABLE_ENTITY, arg);
    }
}