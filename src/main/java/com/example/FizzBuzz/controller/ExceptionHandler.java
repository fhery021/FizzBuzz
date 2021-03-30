package com.example.FizzBuzz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Map<String, String> showCustomMessage(Exception e){
        Map<String, String> response =  new HashMap<>();

        response.put("status", "Your input is invalid. Valid integers from 1 to 2^63-1 are acceptable for the sequence to be generated");

        return response;
    }

}
