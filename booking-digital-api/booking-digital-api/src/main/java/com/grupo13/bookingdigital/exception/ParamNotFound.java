package com.grupo13.bookingdigital.exception;

public class ParamNotFound extends RuntimeException {
  public ParamNotFound(String error) {
    super(error);
  }
}
