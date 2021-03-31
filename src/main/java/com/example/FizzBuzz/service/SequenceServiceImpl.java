package com.example.FizzBuzz.service;

import com.example.FizzBuzz.controller.response.SequenceResponse;
import com.example.FizzBuzz.exception.InvalidRangeException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static com.example.FizzBuzz.service.SequenceServiceProperties.MAX_LAST_ELEMENT;

@Service
public class SequenceServiceImpl implements SequenceService {

    @Override
    public SequenceResponse generateSequence(int lastElement) {

        if (lastElement < 1 || lastElement > MAX_LAST_ELEMENT) {
            throw new InvalidRangeException();
        }

        SequenceResponse sequenceResponse = new SequenceResponse(new ArrayList<>());

        IntStream.rangeClosed(1, lastElement)
                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
                .forEach(n -> sequenceResponse.getSequence().add(String.valueOf(n)));

        return sequenceResponse;
    }

}
