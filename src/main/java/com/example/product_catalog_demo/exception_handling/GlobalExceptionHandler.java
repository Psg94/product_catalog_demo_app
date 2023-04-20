package com.example.product_catalog_demo.exception_handling;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionInfo> handleException(MethodArgumentNotValidException e) {
        Optional<FieldError> optionalFieldError = e.getBindingResult().getFieldErrors().stream().findFirst();

        ExceptionInfo exceptionInfo = new ExceptionInfo();

        if (optionalFieldError.isPresent()) {
            FieldError fieldError = optionalFieldError.get();
            exceptionInfo.setErrorMessage(fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(exceptionInfo);
    }
}
