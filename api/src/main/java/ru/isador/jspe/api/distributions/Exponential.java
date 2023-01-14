package ru.isador.jspe.api.distributions;

public class Exponential extends Distribution {

    private float mean;

    public float getMean() {
        return mean;
    }

    public void setMean(float value) {
        this.mean = value;
    }
}
