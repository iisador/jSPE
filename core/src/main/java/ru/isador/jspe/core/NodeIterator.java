package ru.isador.jspe.core;

import java.util.Iterator;

import ru.isador.jspe.core.nodes.Node;

/**
 * Итератор по узлам модели.
 * Порядок узлов зависит от реализации.
 */
public interface NodeIterator<T extends Node> extends Iterator<T> {

    /**
     * Модель, по узлам которой осуществляется итерация.
     *
     * @return модель.
     *
     * @since 2.0.0
     */
    SpeModel<T> getModel();
}
