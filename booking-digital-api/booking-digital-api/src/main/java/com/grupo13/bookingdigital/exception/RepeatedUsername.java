package com.grupo13.bookingdigital.exception;

import org.springframework.security.core.AuthenticationException;

public class RepeatedUsername extends AuthenticationException {
    public RepeatedUsername(String error) {
        super(error);
    }
}
