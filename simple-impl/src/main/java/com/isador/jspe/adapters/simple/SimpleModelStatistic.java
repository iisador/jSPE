package com.isador.jspe.adapters.simple;

import java.util.Map;

import com.isador.jspe.core.ModelPath;
import com.isador.jspe.core.ModelStatistic;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.Resource;

public class SimpleModelStatistic implements ModelStatistic {

    private Map<Payload, Double> totalPayload;
    private Map<Resource, Double> totalResource;
    private ModelPath maxPath;
    private ModelPath minPath;
    private double rating;

    @Override
    public Map<Payload, Double> getTotalPayload() {
        return totalPayload;
    }

    public void setTotalPayload(Map<Payload, Double> totalPayload) {
        this.totalPayload = totalPayload;
    }

    @Override
    public Map<Resource, Double> getTotalResource() {
        return totalResource;
    }

    public void setTotalResource(Map<Resource, Double> totalResource) {
        this.totalResource = totalResource;
    }

    @Override
    public ModelPath getMaxPath() {
        return maxPath;
    }

    public void setMaxPath(ModelPath maxPath) {
        this.maxPath = maxPath;
    }

    @Override
    public ModelPath getMinPath() {
        return minPath;
    }

    public void setMinPath(ModelPath minPath) {
        this.minPath = minPath;
    }

    @Override
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
