package com.hackerrank.weather.exception;

public class BadResourceRequestException extends Exception {
    public BadResourceRequestException(final String msg) {
        super(msg);
    }
}
