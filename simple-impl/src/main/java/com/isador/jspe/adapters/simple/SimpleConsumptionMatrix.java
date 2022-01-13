package com.isador.jspe.adapters.simple;

import java.io.Serial;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.isador.jspe.core.MutableConsumptionMatrix;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.Resource;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;

/**
 * Простая реализация матрицы потребления.
 *
 * @since 1.0.0
 */
public class SimpleConsumptionMatrix implements MutableConsumptionMatrix {

    @Serial
    private static final long serialVersionUID = 1764255936895046173L;

    /** Количество ресурса. */
    private final Map<Resource, Integer> resourceQuantity;

    /** Набор кортежей <Полезная нагрузка - Ресурс - Количество>. */
    private final Set<Tuple<Payload, Resource, Double>> consumption;

    /**
     * Конструктор по умолчанию создаёт объект, в котором
     * количество ресурса реализовано на {@link HashSet},
     * а матрица потребления на {@link HashMap}.
     *
     * @since 2.0.0
     */
    public SimpleConsumptionMatrix() {
        consumption = new HashSet<>();
        resourceQuantity = new HashMap<>();
    }

    @Override
    public double getConsumption(Payload payload, Resource resource) {
        requireNonNull(payload, "payload should be not null");
        requireNonNull(resource, "resource should be not null");

        return consumption.stream()
                .filter(tuple -> tuple.isXYEquals(payload, resource))
                .findFirst()
                .map(Tuple::v)
                .orElse(0.0);
    }

    @Override
    public Collection<Resource> getMappedResources(Payload payload) {
        return consumption.stream()
                .filter(tuple -> tuple.x().equals(payload))
                .map(Tuple::y)
                .collect(toSet());
    }

    @Override
    public void setConsumption(Payload payload, Resource resource, double value) {
        setConsumption(payload, resource, value, 1);
    }

    @Override
    public void setConsumption(Payload payload, Resource resource, double value, int quantity) {
        requireNonNull(payload, "payload should be not null");
        requireNonNull(resource, "resource should be not null");

        if (Double.compare(value, 0.0) <= 0) {
            throw new IllegalArgumentException("value should be > 0.0");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("resourceQuantity should be > 0.0");
        }

        consumption.add(new Tuple<>(payload, resource, value));
        resourceQuantity.put(resource, quantity);
    }

    @Override
    public Integer getResourceQuantity(Resource resource) {
        requireNonNull(resource, "resource should be not null");
        return resourceQuantity.get(resource);
    }

    @Override
    public void setResourceQuantity(Resource resource, int quantity) {
        requireNonNull(resource, "resource should be not null");
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity should be > 0.0");
        }
        resourceQuantity.put(resource, quantity);
    }

    @Override
    public void remove(Payload payload, Resource resource) {
        consumption.removeIf(tuple -> tuple.isXYEquals(payload, resource));
    }

    @Override
    public String toString() {
        return "SimpleConsumptionMatrix{" +
               "resourceQuantity=" + resourceQuantity +
               ", consumption=" + consumption +
               '}';
    }

    /**
     * Простая реализация неизменяемого кортежа.
     *
     * @since 2.0.0
     */
    record Tuple<X, Y, V>(X x, Y y, V v) {

        public Tuple(X x, Y y, V v) {
            this.x = requireNonNull(x, "X parameter should be not null");
            this.y = requireNonNull(y, "Y parameter should be not null");
            this.v = requireNonNull(v, "V parameter should be not null");
        }

        public boolean isXYEquals(X x, Y y) {
            return this.x.equals(x) && this.y.equals(y);
        }
    }
}
