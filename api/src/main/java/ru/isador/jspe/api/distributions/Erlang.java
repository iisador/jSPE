package ru.isador.jspe.api.distributions;

public class Erlang extends Distribution {

    private float mean;
    private float variance;

    public float getMean() {
        return mean;
    }

    public void setMean(float value) {
        this.mean = value;
    }

    public float getVariance() {
        return variance;
    }

    public void setVariance(float value) {
        this.variance = value;
    }
}
