package com.isador.jspe.core.impls.simple;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Tuple<X, Y, V> {

    private final X x;
    private final Y y;
    private V v;

    public Tuple(X x, Y y, V v) {
        this.x = requireNonNull(x, "X parameter should be not null");
        this.y = requireNonNull(y, "Y parameter should be not null");
        this.v = requireNonNull(v, "Value should be not null");
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = requireNonNull(v, "Value should be not null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple<?, ?, ?> tuple = (Tuple<?, ?, ?>) o;
        return x.equals(tuple.x) && y.equals(tuple.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Tuple{" +
               "x=" + x +
               ", y=" + y +
               ", v=" + v +
               '}';
    }
}
