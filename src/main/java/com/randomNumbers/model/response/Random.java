package com.randomNumbers.model.response;

import java.io.Serializable;
import java.util.List;

public class Random implements Serializable {

    private List<Integer> data;
    private String completionTime;

    public Random(){
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }
}
