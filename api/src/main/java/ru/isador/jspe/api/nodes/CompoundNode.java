package ru.isador.jspe.api.nodes;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Составной узел.
 * Полезной работы не совершает.
 *
 * @since 1.0.0
 */
public class CompoundNode extends Node {

    private final Collection<ProcessingNode> nodes;

    public CompoundNode() {
        nodes = new ArrayList<>();
    }

    public Collection<ProcessingNode> getNodes() {
        return nodes;
    }
}
