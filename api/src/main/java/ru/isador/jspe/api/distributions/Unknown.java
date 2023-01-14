package ru.isador.jspe.api.distributions;

public class Unknown extends Distribution {

    private float mean;
    private float min;
    private float max;

    public float getMean() {
        return mean;
    }

    public void setMean(float value) {
        this.mean = value;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float value) {
        this.min = value;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float value) {
        this.max = value;
    }
}
