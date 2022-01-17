package com.isador.jspe.adapters.simple;

import java.io.Serializable;
import java.util.Map;

public class ModelStatistic implements Serializable {

    private Map<Payload, Double> totalPayload;
    private Map<Resource, Double> totalResource;
    private ModelPath maxPath;
    private ModelPath minPath;
    private double rating;

    public Map<Payload, Double> getTotalPayload() {
        return totalPayload;
    }

    public void setTotalPayload(Map<Payload, Double> totalPayload) {
        this.totalPayload = totalPayload;
    }

    public Map<Resource, Double> getTotalResource() {
        return totalResource;
    }

    public void setTotalResource(Map<Resource, Double> totalResource) {
        this.totalResource = totalResource;
    }

    public ModelPath getMaxPath() {
        return maxPath;
    }

    public void setMaxPath(ModelPath maxPath) {
        this.maxPath = maxPath;
    }

    public ModelPath getMinPath() {
        return minPath;
    }

    public void setMinPath(ModelPath minPath) {
        this.minPath = minPath;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
