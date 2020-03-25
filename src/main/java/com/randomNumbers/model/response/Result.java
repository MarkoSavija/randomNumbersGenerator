package com.randomNumbers.model.response;

import java.io.Serializable;

public class Result implements Serializable {

    private Random random;
    private int bitsUsed;
    private int bitsLeft;
    private int requestsLeft;
    private int advisoryDelay;

    public Result() {
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getBitsUsed() {
        return bitsUsed;
    }

    public void setBitsUsed(int bitsUsed) {
        this.bitsUsed = bitsUsed;
    }

    public int getBitsLeft() {
        return bitsLeft;
    }

    public void setBitsLeft(int bitsLeft) {
        this.bitsLeft = bitsLeft;
    }

    public int getRequestsLeft() {
        return requestsLeft;
    }

    public void setRequestsLeft(int requestsLeft) {
        this.requestsLeft = requestsLeft;
    }

    public int getAdvisoryDelay() {
        return advisoryDelay;
    }

    public void setAdvisoryDelay(int advisoryDelay) {
        this.advisoryDelay = advisoryDelay;
    }
}
