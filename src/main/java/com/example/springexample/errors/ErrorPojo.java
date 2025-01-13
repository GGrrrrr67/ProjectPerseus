package com.example.springexample.errors;

import org.springframework.http.HttpStatus;

public class ErrorPojo {

    private int code;
    private HttpStatus status;
    private String message;

    public ErrorPojo(HttpStatus status, String message) {
        this.status = status;
        this.code = status.value();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
