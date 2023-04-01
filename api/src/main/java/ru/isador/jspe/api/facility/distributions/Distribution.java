package ru.isador.jspe.api.facility.distributions;

public class Distribution {

    private String name;

    public Distribution() {
    }

    public Distribution(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
