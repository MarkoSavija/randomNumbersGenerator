package com.randomNumbers.service;

import com.randomNumbers.model.*;
import com.randomNumbers.model.request.RequestParams;
import com.randomNumbers.model.request.RequestData;
import com.randomNumbers.model.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RandomNumberService {

    @Value("${randomOrgApiKey}")
    private String apiKey;
    @Value("${jsonrpc}")
    private String jsonrpc;
    @Value("${uri}")
    private String resourceUrl;
    @Value("${generateIntegersMethod}")
    private String methodName;

    private static final AtomicInteger counter = new AtomicInteger(); //thread safe generating unique integers

    public List<NumberSequencePair> generateRandomNumbers(ClientParameters params) {
        List<Integer> randomNumbers = getNumbers(params);
        return findSequences(randomNumbers);
    }

    private List<Integer> getNumbers(ClientParameters params) {
        RestTemplate restTemplate = new RestTemplate();
        RequestParams parameters = new RequestParams(apiKey, params.getNumberOfNumbers(), params.getRangeMin(), params.getRangeMax());
        HttpEntity<RequestData> request = new HttpEntity<>(new RequestData(jsonrpc, methodName, parameters, nextValue()));
        Response res = restTemplate.postForObject(resourceUrl, request, Response.class);

        return res.getResult().getRandom().getData();
    }

    public static int nextValue() {
        return counter.getAndIncrement();
    }

    private List<NumberSequencePair> findSequences(List<Integer> randomNumbers){
        List<NumberSequencePair> numbersAndSequences = new ArrayList<>();
        outerloop:
        for(int i: randomNumbers){
            for (NumberSequencePair numSeq: numbersAndSequences){
                if(i == numSeq.getNumber()){
                    continue outerloop;
                }
            }
            NumberSequencePair ns = new NumberSequencePair();
            ns.setNumber(i);
            ns.setSequence(Collections.frequency(randomNumbers, i));
            numbersAndSequences.add(ns);
        }
        return numbersAndSequences;
    }

}

