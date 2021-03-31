package com.example.FizzBuzz.service;

import com.example.FizzBuzz.controller.response.SequenceResponse;
import com.example.FizzBuzz.exception.InvalidRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.example.FizzBuzz.service.SequenceServiceProperties.MAX_LAST_ELEMENT;
import static org.junit.jupiter.api.Assertions.assertEquals;

// No repository => not a @SpringBootTest
class SequenceServiceImplTest {

    SequenceService sequenceService = new SequenceServiceImpl();

    @Test
    void generateSmallerSequence() {
        SequenceResponse expectedSequence = new SequenceResponse(Arrays.asList(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
                "11", "Fizz", "13", "14", "FizzBuzz"));
        SequenceResponse actualSequence = sequenceService.generateSequence(15);

        assertEquals(expectedSequence.getSequence(), actualSequence.getSequence());
    }

    @Test
    void generateWithZero() {
        Assertions.assertThrows(InvalidRangeException.class, () -> sequenceService.generateSequence(0));
    }

    @Test
    void generateOneElement() {
        SequenceResponse expectedSequence = new SequenceResponse(Arrays.asList("1"));
        SequenceResponse actualSequence = sequenceService.generateSequence(1);

        assertEquals(actualSequence.getSequence().size(), 1);
        assertEquals(expectedSequence.getSequence(), actualSequence.getSequence());
    }

    @Test
    void biggestSequence() {
        SequenceResponse actualResponse = sequenceService.generateSequence(MAX_LAST_ELEMENT);

        assertEquals(actualResponse.getSequence().size(), MAX_LAST_ELEMENT);
    }

    @Test
    void biggerThanRange() {
        Assertions.assertThrows(InvalidRangeException.class, () -> sequenceService.generateSequence(MAX_LAST_ELEMENT + 1));
    }

    @Test
    void minusNumber() {
        Assertions.assertThrows(InvalidRangeException.class, () -> sequenceService.generateSequence(-5));
    }

}