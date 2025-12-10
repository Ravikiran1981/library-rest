package com.assist.lms.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<?> handleNotFound(NotFoundException ex) {
    return ResponseEntity.status(404).body(new ErrorResponse("NOT_FOUND", ex.getMessage()));
  }

  static class ErrorResponse {
    private String code;
    private String message;
    public ErrorResponse(String code, String message) {
      this.code = code; this.message = message;
    }
    public String getCode() { return code; }
    public String getMessage() { return message; }
  }
}