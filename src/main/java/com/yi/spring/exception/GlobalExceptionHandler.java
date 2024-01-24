package com.yi.spring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
//import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private final HttpStatus HTTP_STATUS_OK = HttpStatus.OK;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("handleMethodArgumentNotValidException", ex);
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            stringBuilder.append(fieldError.getField()).append(":");
            stringBuilder.append(fieldError.getDefaultMessage());
            stringBuilder.append(", ");
        }
        final ErrorResponse response = ErrorResponse.of(ErrorCode.NOT_VALID_ERROR, String.valueOf(stringBuilder));
        return new ResponseEntity<>(response, HTTP_STATUS_OK);
    }

    @ExceptionHandler(Exception.class)
    protected final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
        log.error("Exception----------------", ex);
        System.out.println("111111111111111111");
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(response, HTTP_STATUS_OK);
    }
}