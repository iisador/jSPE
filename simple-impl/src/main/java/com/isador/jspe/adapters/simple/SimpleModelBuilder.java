package com.isador.jspe.adapters.simple;

import com.isador.jspe.core.ModelBuilder;
import com.isador.jspe.core.MutableConsumptionMatrix;
import com.isador.jspe.core.SpeModel;
import com.isador.jspe.core.nodes.Node;
import com.isador.jspe.core.nodes.NodeBuilder;

public class SimpleModelBuilder implements ModelBuilder {

    private SimpleModel model;

    public SimpleModelBuilder() {
        model = new SimpleModel();
    }

    @Override
    public SpeModel build() {
        return model;
    }

    @Override
    public void add(Node node) {

    }

    @Override
    public void add(Node node, Node parent) {

    }

    @Override
    public Node getNode(String id) {
        return null;
    }

    @Override
    public NodeBuilder getNodeBuilder() {
        return null;
    }

    @Override
    public MutableConsumptionMatrix getConsumptionMatrix() {
        return null;
    }
}
