package ru.isador.jspe.api.distributions;

public class Uniform extends Distribution {

    private float min;
    private float max;

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
