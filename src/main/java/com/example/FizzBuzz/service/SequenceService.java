package com.example.FizzBuzz.service;

import com.example.FizzBuzz.controller.response.SequenceResponse;

public interface SequenceService {

    SequenceResponse generateSequence(long lastElement);

}
