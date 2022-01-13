package com.isador.jspe.adapters.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

import com.isador.jspe.adapters.simple.nodes.AbstractCompoundNode;
import com.isador.jspe.adapters.simple.nodes.AbstractNode;
import com.isador.jspe.core.NodeIterator;
import com.isador.jspe.core.SpeModel;
import com.isador.jspe.core.nodes.CompoundNode;

import static java.util.Objects.requireNonNull;

/**
 * Простая реализация итератора по узлам модели.
 * Рекурсивно обходит потомков начального узла в ширину.
 * Также позволяет обнаружить циклические связи.
 *
 * @since 1.0.0
 */
public class SimpleNodeIterator implements NodeIterator {

    /** Очередь потомков. */
    private final Queue<AbstractNode> queue;

    /** Коллекция помеченных узлов. */
    private final Collection<String> markedNodes;

    private final SpeModel speModel;

    /**
     * Конструктор для создания итератора.
     *
     * @param node стартовый узел.
     *
     * @throws NullPointerException если node == null.
     * @since 1.0.0
     */
    public SimpleNodeIterator(final AbstractNode node, final SpeModel speModel) {
        requireNonNull(node, "Node should be not null");
        this.speModel = requireNonNull(speModel, "SpeModel should be not null");

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
            List<AbstractNode> unmarkedNodes = new ArrayList<>();
            unmarkedNodes.add(node.getNext());
            if(node instanceof AbstractCompoundNode) {
                unmarkedNodes.addAll(node.getChilds());
            }
            unmarkedNodes.removeIf(n -> markedNodes.contains(n.getId()));
            queue.addAll(unmarkedNodes);
        }
        return node;
    }

    @Override
    public SpeModel getModel() {
        return speModel;
    }
}
