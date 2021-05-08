package com.isador.jspe.core.impls.simple;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.Resource;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;

public class SimpleConsumptionMatrix implements ConsumptionMatrix, Serializable {

    private final Set<Tuple<Payload, Resource, Double>> consumption;

    public SimpleConsumptionMatrix() {
        consumption = new HashSet<>();
    }

    @Override
    public Double getConsumption(Payload payload, Resource resource) {
        requireNonNull(payload, "payload should be not null");
        requireNonNull(resource, "resource should be not null");

        return consumption.stream()
                .filter(tuple -> tuple.getX().equals(payload) && tuple.getY().equals(resource))
                .findFirst()
                .map(Tuple::getV)
                .orElse(0.0);
    }

    @Override
    public Collection<Resource> getMappedResources(Payload payload) {
        return consumption.stream()
                .filter(tuple -> tuple.getX().equals(payload))
                .map(Tuple::getY)
                .collect(toSet());
    }

    @Override
    public void setConsumption(Payload payload, Resource resource, Double value) {
        requireNonNull(payload, "payload should be not null");
        requireNonNull(resource, "resource should be not null");
        requireNonNull(value, "value should be not null");

        if (Double.compare(value, 0.0) <= 0) {
            throw new IllegalArgumentException("value should be > 0.0");
        }

        consumption.add(new Tuple<>(payload, resource, value));
    }

    @Override
    public void remove(Payload payload, Resource resource) {
        consumption.removeIf(tuple -> tuple.getX().equals(payload) && tuple.getY().equals(resource));
    }

    @Override
    public String toString() {
        return "SimpleConsumptionMatrix{" +
               "consumption=" + consumption +
               '}';
    }
}
