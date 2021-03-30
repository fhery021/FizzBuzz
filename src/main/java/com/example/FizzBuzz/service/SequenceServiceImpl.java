package com.example.FizzBuzz.service;

import com.example.FizzBuzz.controller.response.SequenceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.LongStream;

@Service
public class SequenceServiceImpl implements SequenceService {

    @Override
    public SequenceResponse generateSequence(long lastElement) {
        SequenceResponse response = new SequenceResponse(new ArrayList<>());

        LongStream.rangeClosed(1, lastElement)
                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
                .forEach(n -> response.getSequence().add(String.valueOf(n)));

        return response;
    }

}
