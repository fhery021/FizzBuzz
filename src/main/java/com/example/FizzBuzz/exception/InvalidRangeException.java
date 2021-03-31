package com.example.FizzBuzz.exception;

public class InvalidRangeException extends RuntimeException{

    public static final String CUSTOM_MESSAGE = "Invalid input. The lastSequence parameter should be in range [1..2_000_000]";

    public InvalidRangeException() {
        super(CUSTOM_MESSAGE);
    }
}
