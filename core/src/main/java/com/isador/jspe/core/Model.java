package com.isador.jspe.core;

import java.util.Optional;

/**
 * Модель системы.
 *
 * @since 1.0.0
 */
public interface Model extends Iterable<Node> {

    /**
     * Получить узел модели.
     *
     * @param id ID узла.
     *
     * @return узел модели.
     *
     * @since 1.0.0
     */
    Optional<Node> getNode(String id);

    /**
     * Добавить стартовый узел в модель.
     *
     * @param node новый стартовый узел модели
     *
     * @since 1.0.0
     */
    void addNode(Node node);

    /**
     * Проверка модели на пустоту.
     *
     * @return true - если модель не модердит ни одного узла, false - в другом случае.
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
     * Матрица накладных расходов модели.
     *
     * @return Матрица накладных расходов.
     *
     * @since 1.0.0
     */
    OverheadMatrix getOverheadMatrix();

    /**
     * Валидация модели.
     *
     * @throws InvalidModelException если модель невалидна.
     * @since 1.0.0
     */
    void validate() throws InvalidModelException;
}
