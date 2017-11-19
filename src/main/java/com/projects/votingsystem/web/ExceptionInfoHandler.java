package com.projects.votingsystem.web;

import com.projects.votingsystem.util.Exception.ApplicationException;
import com.projects.votingsystem.util.Exception.ErrorInfo;
import com.projects.votingsystem.util.Exception.ErrorType;
import com.projects.votingsystem.util.Exception.TimeOutOfBoundsException;
import com.projects.votingsystem.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@ControllerAdvice
@ResponseBody
public class ExceptionInfoHandler {
    private static Logger log = LoggerFactory.getLogger(ExceptionInfoHandler.class);

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorInfo> applicationError(HttpServletRequest req, ApplicationException appEx) {
        ErrorInfo errorInfo = logAndGetErrorInfo(req, appEx);
        return new ResponseEntity<>(errorInfo, appEx.getHttpStatus());
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorInfo conflict(HttpServletRequest req, DataIntegrityViolationException e) {
        return logAndGetErrorInfo(req, ErrorType.DATA_ERROR ,e);
    }

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorInfo validationError(HttpServletRequest req, MethodArgumentNotValidException e) {
        return logAndGetErrorInfo(req, ErrorType.VALIDATION_ERROR, e);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TimeOutOfBoundsException.class)
    public ErrorInfo validationError(HttpServletRequest req, TimeOutOfBoundsException e) {
        return logAndGetErrorInfo(req, ErrorType.TIME_EXPIRED, e);
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorInfo handleError(HttpServletRequest req, Exception e) {
        return logAndGetErrorInfo(req, ErrorType.APP_ERROR, e);
    }


    private ErrorInfo logAndGetErrorInfo(HttpServletRequest req, ErrorType type, Exception e) {
        Throwable rootCause = ValidationUtil.getRootCause(e);
        log.warn("Error at request  {}: {}", req.getRequestURL(), rootCause.toString());
        return new ErrorInfo(req.getRequestURL().toString(), type, e);
    }

    private ErrorInfo logAndGetErrorInfo(HttpServletRequest req, Exception e) {
        Throwable rootCause = ValidationUtil.getRootCause(e);
        log.warn("Error at request  {}: {}", req.getRequestURL(), rootCause.toString());
        return new ErrorInfo(req.getRequestURL().toString(), e);
    }

}
