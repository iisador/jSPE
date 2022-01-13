package com.isador.jspe.core;


import com.isador.jspe.core.nodes.Node;
import com.isador.jspe.core.nodes.NodeBuilder;

/**
 * @since 2.0.0
 */
public interface ModelBuilder {

    SpeModel build();

    void add(Node node);

    void add(Node node, Node parent);

    Node getNode(String id);

    NodeBuilder getNodeBuilder();

    MutableConsumptionMatrix getConsumptionMatrix();
}
