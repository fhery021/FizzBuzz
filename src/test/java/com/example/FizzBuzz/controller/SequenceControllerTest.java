package com.example.FizzBuzz.controller;

import com.example.FizzBuzz.controller.response.SequenceResponse;
import com.example.FizzBuzz.exception.InvalidRangeException;
import com.example.FizzBuzz.exception.NoInputDataException;
import com.example.FizzBuzz.service.SequenceService;
import com.example.FizzBuzz.service.SequenceServiceProperties;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SequenceController.class)
class SequenceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SequenceService sequenceService;

    @Test
    public void generateSequenceNominal() throws Exception {
        SequenceResponse sequenceResponse = new SequenceResponse(Arrays.asList(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
                "11", "Fizz", "13", "14", "FizzBuzz"));

        given(sequenceService.generateSequence(15)).willReturn(sequenceResponse);

        mvc.perform(get("/api/fizzbuzz/sequence")
                .queryParam("lastElement", String.valueOf(15)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("sequence").isNotEmpty());
    }

    @Test
    public void generateSequenceEmpty() throws Exception {
        mvc.perform(get("/api/fizzbuzz/sequence")
                .queryParam("lastElement", ""))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("timestamp").isNotEmpty())
                .andExpect(jsonPath("message").isNotEmpty())
                .andExpect(jsonPath("message").value(NoInputDataException.CUSTOM_MESSAGE));
    }

    @Test
    public void generateSequenceMinusParam() throws Exception {
        mvc.perform(get("/api/fizzbuzz/sequence")
                .queryParam("lastElement", "-5"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("timestamp").isNotEmpty())
                .andExpect(jsonPath("message").isNotEmpty())
                .andExpect(jsonPath("message").value(InvalidRangeException.CUSTOM_MESSAGE));
    }

    @Test
    public void generateSequenceTooBigParam() throws Exception {
        int outOfRangeElement = SequenceServiceProperties.MAX_LAST_ELEMENT + 1;

        mvc.perform(get("/api/fizzbuzz/sequence")
                .queryParam("lastElement", String.valueOf(outOfRangeElement)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("timestamp").isNotEmpty())
                .andExpect(jsonPath("message").isNotEmpty())
                .andExpect(jsonPath("message").value(InvalidRangeException.CUSTOM_MESSAGE));
    }

}