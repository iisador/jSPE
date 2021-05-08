package com.isador.jspe.core.impls.simple;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.isador.jspe.core.Matrix;

public class SimpleMatrix<T extends Serializable> implements Matrix<T> {

    protected final Map<T, Double> matrix;

    public SimpleMatrix(Map<T, Double> matrix) {
        this.matrix = matrix;
    }

    public SimpleMatrix() {
        matrix = new HashMap<>();
    }

    @Override
    public Double put(T t) {
        return matrix.put(t, 1.0);
    }

    @Override
    public Double put(T t, Double quantity) {
        return matrix.put(t, quantity);
    }

    @Override
    public Double remove(Object t) {
        return matrix.remove(t);
    }

    @Override
    public void putAll(Map<? extends T, ? extends Double> m) {
        matrix.putAll(m);
    }

    @Override
    public void clear() {
        matrix.clear();
    }

    @Override
    public Set<T> keySet() {
        return matrix.keySet();
    }

    @Override
    public Collection<Double> values() {
        return matrix.values();
    }

    @Override
    public Set<Entry<T, Double>> entrySet() {
        return matrix.entrySet();
    }

    @Override
    public void setQuantity(T t, double quantity) {
        matrix.computeIfPresent(t, (k, v) -> quantity);
    }

    @Override
    public int size() {
        return matrix.size();
    }

    @Override
    public boolean isEmpty() {
        return matrix.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return matrix.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return matrix.containsValue(value);
    }

    @Override
    public Double get(Object key) {
        return matrix.getOrDefault(key, 0.0);
    }

    @Override
    public Matrix<T> plus(Matrix<T> matrix) {
        Set<T> payloads = new HashSet<>(matrix.keySet());
        payloads.addAll(matrix.keySet());

        return payloads.stream()
                .map(payload -> plus(payload, this, matrix))
                .collect(SimpleMatrix::new,
                        (m, e) -> m.put(e.getKey(), e.getValue()),
                        (m, l) -> l.forEach(m::put));
    }

    private Entry<T, Double> plus(T t, Matrix<T> m1, Matrix<T> m2) {
        return new AbstractMap.SimpleEntry<>(t, m1.get(t) + m2.get(t));
    }

    @Override
    public String toString() {
        return "SimpleMatrix{" +
               "matrix=" + matrix +
               '}';
    }
}
