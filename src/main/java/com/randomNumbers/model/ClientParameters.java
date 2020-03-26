package com.randomNumbers.model;

import javax.validation.constraints.NotNull;

public class ClientParameters {

    @NotNull
    private Integer rangeMin;
    @NotNull
    private Integer rangeMax;
    @NotNull
    private Integer numberOfNumbers;

    public ClientParameters(Integer rangeMin, Integer rangeMax, Integer numberOfNumbers) {
        this.rangeMin = rangeMin;
        this.rangeMax = rangeMax;
        this.numberOfNumbers = numberOfNumbers;
    }

    public Integer getRangeMin() {
        return rangeMin;
    }

    public void setRangeMin(Integer rangeMin) {
        this.rangeMin = rangeMin;
    }

    public Integer getRangeMax() {
        return rangeMax;
    }

    public void setRangeMax(Integer rangeMax) {
        this.rangeMax = rangeMax;
    }

    public Integer getNumberOfNumbers() {
        return numberOfNumbers;
    }

    public void setNumberOfNumbers(Integer numberOfNumbers) {
        this.numberOfNumbers = numberOfNumbers;
    }
}
