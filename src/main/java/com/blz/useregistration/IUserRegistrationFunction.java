package com.blz.useregistration;

    @FunctionalInterface
    public interface IUserRegistrationFunction {
        boolean validate(String value, String pattern) throws UserDetailException;
    }

