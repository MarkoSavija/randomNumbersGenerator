package com.randomNumbers.model;

public class ClientParameters {

    private int rangeMin;
    private int rangeMax;
    private int numberOfNumbers;

    public ClientParameters(int rangeMin, int rangeMax, int numberOfNumbers) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        this.numberOfNumbers = numberOfNumbers;
    }

    public int getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(int rangeMin) {
        this.rangeMin = rangeMin;
    }

    public int getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(int rangeMax) {
        this.rangeMax = rangeMax;
    }

    public int getNumberOfNumbers() {
        return numberOfNumbers;
    }

    public void setNumberOfNumbers(int numberOfNumbers) {
        this.numberOfNumbers = numberOfNumbers;
    }
}
