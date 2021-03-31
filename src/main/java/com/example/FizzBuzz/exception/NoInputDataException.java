package com.example.FizzBuzz.exception;

public class NoInputDataException extends RuntimeException {

    public NoInputDataException() {
        super("Insufficient input. The lastSequence parameter is mandatory and should be in range [1..2_000_000]");
    }
}
