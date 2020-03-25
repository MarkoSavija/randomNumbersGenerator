package com.randomNumbers.controller;

import com.randomNumbers.model.ClientParameters;
import com.randomNumbers.model.NumberSequencePair;
import com.randomNumbers.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RandomNumberController {

    @Autowired
    private RandomNumberService randomNumberService;

    @PostMapping(value = "/numbers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<NumberSequencePair> generateNumbers(@RequestBody ClientParameters params ) {
        return randomNumberService.generateRandomNumbers(params);
    }
}
