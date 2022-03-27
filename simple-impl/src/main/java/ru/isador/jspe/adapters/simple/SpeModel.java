package ru.isador.jspe.adapters.simple;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;
import java.util.stream.StreamSupport;

import ru.isador.jspe.adapters.simple.nodes.AbstractNode;

public class SpeModel implements Iterable<AbstractNode>, Serializable {

    @Serial
    private static final long serialVersionUID = -7230677770877873149L;

    private AbstractNode node;
    private ConsumptionMatrix consumptionMatrix;

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

    public ConsumptionMatrix getConsumptionMatrix() {
        return consumptionMatrix;
    }

    public void setConsumptionMatrix(ConsumptionMatrix consumptionMatrix) {
        this.consumptionMatrix = consumptionMatrix;
    }

    public NodeIterator iterator() {
        return new NodeIterator(node, this);
    }
}
