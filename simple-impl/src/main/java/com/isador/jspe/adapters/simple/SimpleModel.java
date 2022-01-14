package com.isador.jspe.adapters.simple;

import java.io.Serial;
import java.util.Optional;
import java.util.stream.StreamSupport;

import com.isador.jspe.adapters.simple.nodes.AbstractNode;
import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.SpeModel;

public class SimpleModel implements SpeModel<AbstractNode> {

    @Serial
    private static final long serialVersionUID = -7230677770877873149L;

    private AbstractNode node;
    private ConsumptionMatrix consumptionMatrix;

    @Override
    public Optional<AbstractNode> getNode(String id) {
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
    public SimpleNodeIterator iterator() {
        return new SimpleNodeIterator(node, this);
    }
}
