package com.isador.jspe.core;

import java.io.Serializable;
import java.util.Optional;

import com.isador.jspe.core.nodes.Node;

/**
 * Модель системы.
 *
 * @since 1.0.0
 */
public interface SpeModel<N extends Node> extends Iterable<N>, Serializable {

    /**
     * Получить узел модели.
     *
     * @param id ID узла.
     *
     * @return узел модели.
     *
     * @since 1.0.0
     */
    Optional<N> getNode(String id);

    /**
     * Получить стартовый узел модели.
     *
     * @return узел модели.
     *
     * @since 1.0.0
     */
    Optional<N> getNode();

    /**
     * Добавить стартовый узел в модель.
     *
     * @param node новый стартовый узел модели
     *
     * @since 1.0.0
     */
    void addNode(N node);

    /**
     * Добавить узел в модель.
     *
     * @param parent родительский узел.
     * @param child  новый стартовый узел модели
     *
     * @since 1.0.0
     */
    void addNode(N parent, N child);

    /**
     * Проверка модели на пустоту.
     *
     * @return true - если модель не содержит ни одного узла, false - в другом случае.
     *
     * @since 1.0.0
     */
    boolean isEmpty();

    /**
     * Матрица потребления ресурсов модели.
     *
     * @return Матрица потребления ресурсов.
     *
     * @since 1.0.0
     */
    ConsumptionMatrix getConsumptionMatrix();

    /**
     * Построение статистики модели.
     *
     * @return статистика модели.
     *
     * @since 2.0.0
     */
    ModelStatistic getStatistic();

    /**
     * Валидация модели.
     *
     * @throws InvalidModelException если модель невалидна.
     * @since 1.0.0
     */
    void validate() throws InvalidModelException;
}
