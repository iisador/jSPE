package com.isador.jspe.core;

import java.io.Serializable;
import java.util.Optional;

import com.isador.jspe.core.nodes.Node;

/**
 * Модель системы.
 *
 * @since 1.0.0
 */
public interface SpeModel extends Serializable, Iterable<Node> {

    /**
     * Получить узел модели.
     *
     * @param id ID узла.
     *
     * @return узел модели.
     *
     * @since 1.0.0
     */
    Optional<? extends Node> getNode(String id);

    /**
     * Матрица потребления ресурсов модели.
     *
     * @return Матрица потребления ресурсов.
     *
     * @since 1.0.0
     */
    ConsumptionMatrix getConsumptionMatrix();
}
