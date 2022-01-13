package com.isador.jspe.core;

import java.io.Serializable;
import java.util.Optional;

import com.isador.jspe.core.nodes.Node;

/**
 * Модель системы.
 *
 * @since 1.0.0
 */
public interface SpeModel<T extends Node> extends Serializable, Iterable<T> {

    /**
     * Получить узел модели.
     *
     * @param id ID узла.
     *
     * @return узел модели.
     *
     * @since 1.0.0
     */
    Optional<T> getNode(String id);

    /**
     * Матрица потребления ресурсов модели.
     *
     * @return Матрица потребления ресурсов.
     *
     * @since 1.0.0
     */
    ConsumptionMatrix getConsumptionMatrix();
}
