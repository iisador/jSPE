package com.isador.jspe.adapters.simple;

import java.io.Serial;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.StreamSupport;

import com.isador.jspe.adapters.simple.nodes.AbstractNode;
import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.SpeModel;
import com.isador.jspe.core.nodes.Node;

public class SimpleModel implements SpeModel {

    @Serial
    private static final long serialVersionUID = -7230677770877873149L;

    private AbstractNode node;
    private ConsumptionMatrix consumptionMatrix;

    @Override
    public Optional<? extends Node> getNode(String id) {
        return StreamSupport.stream(spliterator(), false)
                .filter(node -> node.getId().equals(id))
                .findFirst();
    }

    public Optional<AbstractNode> getNode() {
        return Optional.ofNullable(node);
    }

    public void setNode(AbstractNode node) {
        this.node = node;
    }

    @Override
    public ConsumptionMatrix getConsumptionMatrix() {
        return consumptionMatrix;
    }

    public void setConsumptionMatrix(ConsumptionMatrix consumptionMatrix) {
        this.consumptionMatrix = consumptionMatrix;
    }

    @Override
    public Iterator<Node> iterator() {
        return new SimpleNodeIterator(node, this);
    }
}
