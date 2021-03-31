package com.example.FizzBuzz.service;

import com.example.FizzBuzz.controller.response.SequenceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Service
public class SequenceServiceImpl implements SequenceService {

    @Override
    public SequenceResponse generateSequence(int lastElement) {
        SequenceResponse sequenceResponse = new SequenceResponse(new ArrayList<>());

        IntStream.rangeClosed(1, lastElement)
                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
                .forEach(n -> sequenceResponse.getSequence().add(String.valueOf(n)));

        return sequenceResponse;
    }

}
