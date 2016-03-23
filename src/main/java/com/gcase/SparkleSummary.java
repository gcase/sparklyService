package com.gcase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z0019vj on 3/22/16.
 */
public class SparkleSummary {

    private String name;
    private int sparkles;
    private List<String> positives = new ArrayList<>();
    private List<String> negatives = new ArrayList<>();

    public int getSparkles() {
        return sparkles;
    }

    public void setSparkles(int sparkles) {
        this.sparkles = sparkles;
    }

    public List<String> getPositives() {
        return positives;
    }

    public void setPositives(List<String> positives) {
        this.positives = positives;
    }

    public List<String> getNegatives() {
        return negatives;
    }

    public void setNegatives(List<String> negatives) {
        this.negatives = negatives;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
