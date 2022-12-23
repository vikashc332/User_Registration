package com.blz.useregistration;

public class UserDetailException extends Exception {
    public enum ExceptionTypes{
        ENTERED_NULL,
        ENTERED_EMPTY
    }
    public static ExceptionTypes types;

    public UserDetailException(String message, ExceptionTypes types) {
        super(message);
        this.types = types;
    }
}
