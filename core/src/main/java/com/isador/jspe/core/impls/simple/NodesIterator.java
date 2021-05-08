package com.isador.jspe.core.impls.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import com.isador.jspe.core.Node;

import static java.util.Objects.requireNonNull;

/**
 * Простая реализация итератора по узлам модели.
 * Рекурсивно обходит потомков начального узла в ширину.
 * Также возволяет обнаружить циклические связи.
 *
 * @since 1.0.0
 */
public class NodesIterator implements Iterator<Node> {

    /** Очередь потомков. */
    private final Queue<Node> queue;

    /** Коллекция помеченных узлов. */
    private final Collection<String> markedNodes;

    /** Узел с циклической связью. */
    private Node cyclicNode;

    /**
     * Конструктор для создания итератора.
     *
     * @param node стартовый узел.
     *
     * @throws NullPointerException если node == null.
     * @since 1.0.0
     */
    public NodesIterator(final Node node) {
        requireNonNull(node, "Node should be not null");

        markedNodes = new HashSet<>();
        queue = new ArrayDeque<>();
        queue.add(node);
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** {@inheritDoc} */
    @Override
    public Node next() {
        Node node = queue.poll();
        if (node != null) {
            markedNodes.add(node.getId());
            List<Node> unmarkedNodes = new ArrayList<>(node.getChildList());
            Iterator<Node> it = unmarkedNodes.iterator();
            while (it.hasNext()) {
                var n = it.next();
                if (markedNodes.contains(n.getId())) {
                    cyclicNode = n;
                    it.remove();
                }
            }
            queue.addAll(unmarkedNodes);
        }
        return node;
    }

    /**
     * Вернёт узел с циклической зависимостью.
     *
     * @return узел, найденный при обходе.
     *
     * @since 1.0.0
     */
    public Optional<Node> getCyclicNode() {
        return Optional.ofNullable(cyclicNode);
    }
}
