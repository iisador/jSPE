package ru.isador.jspe.api.graph;

import java.util.Objects;
import java.util.UUID;

public class HardwareResource {

    private final String id;
    private String name;
    private String measure;
    private float serviceTime;

    public HardwareResource() {
        id = UUID.randomUUID().toString();
    }

    public HardwareResource(String id, String name, String measure, float serviceTime) {
        this.id = id;
        this.name = name;
        this.measure = measure;
        this.serviceTime = serviceTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public float getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(float serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HardwareResource that = (HardwareResource) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
