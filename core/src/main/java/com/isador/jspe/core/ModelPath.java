package com.isador.jspe.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.isador.jspe.core.nodes.Node;

/**
 * Путь в модели.
 * Содержит коллекцию узлов системы.
 *
 * @since 2.0.0
 */
public class ModelPath implements Iterable<Node> {

    /** Коллекция узлов. */
    private final List<Node> path;

    /**
     * Конструктор по умолчанию создаёт объект реализованный на {@link ArrayList}.
     *
     * @since 2.0.0
     */
    public ModelPath() {
        path = new ArrayList<>();
    }

    /**
     * Добавить узел в путь.
     *
     * @param node узел для пути.
     *
     * @since 2.0.0
     */
    public void addNode(Node node) {
        path.add(node);
    }

    @Override
    public Iterator<Node> iterator() {
        return path.iterator();
    }
}
