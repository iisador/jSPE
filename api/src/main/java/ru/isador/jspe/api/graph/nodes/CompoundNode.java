package ru.isador.jspe.api.graph.nodes;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Составной узел.
 * Полезной работы не совершает.
 *
 * @since 1.0.0
 */
public abstract class CompoundNode extends AbstractNode {

    private final Collection<Node> nodes;

    public CompoundNode() {
        nodes = new ArrayList<>();
    }

    public Collection<Node> getNodes() {
        return nodes;
    }
}
