package com.example.springexample.errors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.charset.Charset;


public class ErrorHandler extends HttpClientErrorException {

    public ErrorHandler(HttpStatusCode statusCode) {
        super(statusCode);
    }

    public ErrorHandler(HttpStatusCode statusCode, String statusText) {
        super(statusCode, statusText);
    }

    public ErrorHandler(HttpStatusCode statusCode, String statusText, byte[] body, Charset responseCharset) {
        super(statusCode, statusText, body, responseCharset);
    }

    public ErrorHandler(HttpStatusCode statusCode, String statusText, HttpHeaders headers, byte[] body, Charset responseCharset) {
        super(statusCode, statusText, headers, body, responseCharset);
    }

    public ErrorHandler(String message, HttpStatusCode statusCode, String statusText, HttpHeaders headers, byte[] body, Charset responseCharset) {
        super(message, statusCode, statusText, headers, body, responseCharset);
    }
}
