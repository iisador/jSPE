package ru.isador.jspe.api.facility.distributions;

public class Constant extends Distribution {

    private float value;
    private float offset;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getOffset() {
        return offset;
    }

    public void setOffset(float value) {
        this.offset = value;
    }
}
