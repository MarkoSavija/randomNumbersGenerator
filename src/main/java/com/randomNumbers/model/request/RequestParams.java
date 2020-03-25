package com.randomNumbers.model.request;

public class RequestParams {

    private String apiKey;
    private int n;
    private int min;
    private int max;

    public RequestParams(){
    }

    public RequestParams(String apiKey, int n, int min, int max) {
        this.apiKey = apiKey;
        this.n = n;
        this.min = min;
        this.max = max;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
