package com.isador.jspe.adapters.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import static java.util.Objects.requireNonNull;

/**
 * Простая реализация итератора по узлам модели.
 * Рекурсивно обходит потомков начального узла в ширину.
 * Также позволяет обнаружить циклические связи.
 *
 * @since 1.0.0
 */
public class NodesIterator implements Iterator<AbstractNode> {

    /** Очередь потомков. */
    private final Queue<AbstractNode> queue;

    /** Коллекция помеченных узлов. */
    private final Collection<String> markedNodes;

    /** Узел с циклической связью. */
    private AbstractNode cyclicNode;

    /**
     * Конструктор для создания итератора.
     *
     * @param node стартовый узел.
     *
     * @throws NullPointerException если node == null.
     * @since 1.0.0
     */
    public NodesIterator(final AbstractNode node) {
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
    public AbstractNode next() {
        AbstractNode node = queue.poll();
        if (node != null) {
            markedNodes.add(node.getId());
            List<AbstractNode> unmarkedNodes = new ArrayList<>(node.getChildList());
            Iterator<AbstractNode> it = unmarkedNodes.iterator();
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
    public Optional<AbstractNode> getCyclicNode() {
        return Optional.ofNullable(cyclicNode);
    }
}
