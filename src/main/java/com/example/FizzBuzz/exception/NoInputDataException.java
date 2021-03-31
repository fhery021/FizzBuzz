package com.example.FizzBuzz.exception;

public class NoInputDataException extends RuntimeException {

    public static final String CUSTOM_MESSAGE = "Insufficient input. The lastSequence parameter is mandatory and should be in range [1..2_000_000]";

    public NoInputDataException() {
        super(CUSTOM_MESSAGE);
    }

}
