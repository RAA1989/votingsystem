package com.projects.votingsystem.util.Exception;



public class ErrorInfo {

    private final String url;
    private final String ex;
    private final ErrorType type;

    public ErrorInfo(String url, ErrorType type, Exception ex) {
        this.url = url;
        this.type = type;
        this.ex = ex.getLocalizedMessage();
    }

    public ErrorInfo(String url, Exception ex) {
        this.url = url;
        this.type = null;
        this.ex = ex.getLocalizedMessage();
    }
}
