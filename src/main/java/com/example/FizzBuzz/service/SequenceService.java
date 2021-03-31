package com.example.FizzBuzz.service;

import com.example.FizzBuzz.controller.response.SequenceResponse;

import java.util.List;

public interface SequenceService {

    SequenceResponse generateSequence(int lastElement);

}
