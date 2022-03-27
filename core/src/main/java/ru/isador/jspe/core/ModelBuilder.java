package ru.isador.jspe.core;


import java.util.Optional;

import ru.isador.jspe.core.nodes.Node;
import ru.isador.jspe.core.nodes.NodeBuilder;
import ru.isador.jspe.core.nodes.NodeMutator;

/**
 * @since 2.0.0
 */
public interface ModelBuilder<T extends Node> {

    SpeModel<T> build();

    void add(T node);

    void add(String nodeId, T child);

    Optional<T> getNode(String id);

    NodeBuilder<T> getNodeBuilder();

    NodeMutator<T> getNodeMutator(String id);

    MutableConsumptionMatrix getConsumptionMatrix();
}
