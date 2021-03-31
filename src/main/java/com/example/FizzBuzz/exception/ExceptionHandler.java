package com.example.FizzBuzz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NoInputDataException.class)
    public ResponseEntity<Object> handleNoInputDataException(NoInputDataException exception, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Insufficient input. The lastSequence parameter is mandatory and should be in range [1..2_000_000]");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidRangeException.class)
    public ResponseEntity<Object> handleNoInputDataException(InvalidRangeException exception, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Invalid input. The lastSequence parameter is mandatory and should be in range [1..2_000_000]");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
