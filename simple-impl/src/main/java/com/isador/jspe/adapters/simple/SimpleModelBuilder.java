package com.isador.jspe.adapters.simple;

import java.util.Optional;

import com.isador.jspe.adapters.simple.nodes.AbstractNode;
import com.isador.jspe.adapters.simple.nodes.SimpleNodeBuilder;
import com.isador.jspe.core.ModelBuilder;
import com.isador.jspe.core.MutableConsumptionMatrix;
import com.isador.jspe.core.nodes.NodeMutator;

public class SimpleModelBuilder implements ModelBuilder<AbstractNode> {

    private final SimpleModel model;
    private final SimpleConsumptionMatrix consumptionMatrix;

    public SimpleModelBuilder() {
        model = new SimpleModel();
        consumptionMatrix = new SimpleConsumptionMatrix();
        model.setConsumptionMatrix(consumptionMatrix);
    }

    @Override
    public SimpleModel build() {
        return model;
    }

    @Override
    public void add(AbstractNode node) {
        model.setNode(node);
    }

    @Override
    public void add(String nodeId, AbstractNode child) {
        model.getNode(nodeId).ifPresent(n -> n.setNext(child));
    }

    @Override
    public Optional<AbstractNode> getNode(String id) {
        return model.getNode(id);
    }

    @Override
    public SimpleNodeBuilder getNodeBuilder() {
        return new SimpleNodeBuilder();
    }

    @Override
    public NodeMutator<AbstractNode> getNodeMutator(String id) {
        return null;
    }

    @Override
    public MutableConsumptionMatrix getConsumptionMatrix() {
        return consumptionMatrix;
    }
}
