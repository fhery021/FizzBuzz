package com.example.FizzBuzz.controller;

import com.example.FizzBuzz.configuration.SwaggerTags;
import com.example.FizzBuzz.controller.response.SequenceResponse;
import com.example.FizzBuzz.exception.InvalidRangeException;
import com.example.FizzBuzz.exception.NoInputDataException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.FizzBuzz.service.SequenceService;

import java.util.List;

@RestController
@RequestMapping("/api/fizzbuzz")
@Api(tags = {SwaggerTags.FIZZBUZZ})
public class SequenceController {

    private static final int MAX_LAST_ELEMENT = 2_000_000;

    private final SequenceService sequenceService;

    public SequenceController(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    @GetMapping("/sequence")
    @ApiOperation(
            value = "Returns the Fizz Buzz sequence until the last element provided",
            response = SequenceResponse.class
    )
    public ResponseEntity<SequenceResponse> generateSequence(
            @ApiParam("Last element")
            @RequestParam(name = "lastElement", required = true) Integer lastElement
    ){
        if (lastElement == null) {
            throw new NoInputDataException();
        }

        if (lastElement < 1 || lastElement > MAX_LAST_ELEMENT) {
            throw new InvalidRangeException();
        }

        return ResponseEntity
                .ok(sequenceService.generateSequence(lastElement));
    }


}
