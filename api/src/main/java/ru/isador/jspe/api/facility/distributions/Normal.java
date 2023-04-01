package ru.isador.jspe.api.facility.distributions;

public class Normal extends Distribution {

    private float mean;
    private float stdDev;

    public float getMean() {
        return mean;
    }

    public void setMean(float value) {
        this.mean = value;
    }

    public float getStdDev() {
        return stdDev;
    }

    public void setStdDev(float value) {
        this.stdDev = value;
    }
}
