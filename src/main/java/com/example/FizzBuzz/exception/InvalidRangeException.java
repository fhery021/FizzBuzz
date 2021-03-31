package com.example.FizzBuzz.exception;

public class InvalidRangeException extends RuntimeException{

    public InvalidRangeException() {
        super("Invalid input. The lastSequence parameter should be in range [1..2_000_000]");
    }
}
