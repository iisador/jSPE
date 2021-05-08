package com.isador.jspe.core;

import java.util.List;

/**
 * Интерфейс, описывающий узел модели.
 *
 * @since 1.0.0
 */
public interface Node {

    /**
     * Каждый узел должен иметь ID.
     *
     * @since 1.0.0
     */
    String getId();

    /**
     * Краткое описание узла.
     *
     * @return описание. Реализация по умолчанию вернёт {@code Optional.empty()}.
     *
     * @since 1.0.0
     */
    String getTitle();

    /**
     * Получить список потомков текущего узла.
     *
     * @return список потомков. Никода не возвращает null.
     *
     * @since 1.0.0
     */
    List<? extends Node> getChildList();

    /**
     * Добавить потомка.
     *
     * @param node потомок != null.
     *
     * @throws NullPointerException если потомок = null.
     * @since 1.0.0
     */
    void addChild(Node node);

    /**
     * Матрица потребления узла.
     *
     * @return матрица потребления.
     *
     * @since 1.0.0
     */
    Matrix<Payload> getPayloadMatrix();

    /**
     * Флаг валидности текущего узла.
     *
     * @return true, если состояние узла кошерное, false в других случаях.
     *
     * @since 1.0.0
     */
    boolean isValid();
}
