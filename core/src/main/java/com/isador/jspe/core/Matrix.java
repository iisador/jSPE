package com.isador.jspe.core;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptySet;

/** Матрица соответствия объект - количество. */
public interface Matrix<T> extends Map<T, Double> {

    /**
     * Добавить злемент в матрицу с количсеством == 1.0.
     *
     * @param t элемент для добавления.
     *
     * @throws NullPointerException если добавляемый элемент == null.
     * @since 1.0.0
     */
    Double put(T t);

    /**
     * Изменить колчество элементов в матрице.
     *
     * @param t        элемент в матрице.
     * @param quantity количество элементов.
     *
     * @throws NullPointerException     если добавляемый элемент == null.
     * @throws IllegalArgumentException если количество элементов < 1.
     * @throws IllegalStateException    если матрица не содержит элемента.
     * @since 1.0.0
     */
    void setQuantity(T t, double quantity);

    Matrix<T> plus(Matrix<T> matrix);

    final class EmptyMatrix<T> implements Matrix<T> {

        @Override
        public Double put(T t) {
            return null;
        }

        @Override
        public void setQuantity(T t, double quantity) {
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Double get(Object key) {
            return null;
        }

        @Override
        public Double put(T key, Double value) {
            return null;
        }

        @Override
        public Double remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends T, ? extends Double> m) {
        }

        @Override
        public void clear() {
        }

        @Override
        public Set<T> keySet() {
            return emptySet();
        }

        @Override
        public Collection<Double> values() {
            return emptySet();
        }

        @Override
        public Set<Entry<T, Double>> entrySet() {
            return emptySet();
        }

        @Override
        public Matrix<T> plus(Matrix<T> matrix) {
            return emptyMatrix();
        }
    }

    static <T> Matrix<T> emptyMatrix() {
        return new EmptyMatrix<>();
    }
}
