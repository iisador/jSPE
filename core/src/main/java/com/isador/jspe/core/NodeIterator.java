package com.isador.jspe.core;

import java.util.Iterator;

import com.isador.jspe.core.nodes.Node;

/**
 * Итератор по узлам модели.
 * Порядок узлов зависит от реализации.
 */
public interface NodeIterator extends Iterator<Node> {

    /**
     * Модель, по узлам которой осуществляется итерация.
     *
     * @return модель.
     *
     * @since 2.0.0
     */
    SpeModel getModel();
}
