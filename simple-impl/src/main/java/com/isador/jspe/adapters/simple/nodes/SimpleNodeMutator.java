package com.isador.jspe.adapters.simple.nodes;

import java.util.Map;

import com.isador.jspe.core.Payload;
import com.isador.jspe.core.SpeModel;
import com.isador.jspe.core.nodes.NodeMutator;

public class SimpleNodeMutator implements NodeMutator<AbstractNode> {

    private final AbstractNode node;

    public SimpleNodeMutator(AbstractNode node) {
        this.node = node;
    }

    @Override
    public void addCase(AbstractNode child, double probability) {

    }

    @Override
    public void removeCase(AbstractNode child) {

    }

    @Override
    public void setModel(SpeModel<AbstractNode> model) {

    }

    @Override
    public void removeModel() {

    }

    @Override
    public void addStep(AbstractNode child) {

    }

    @Override
    public void removeStep(AbstractNode child) {

    }

    @Override
    public void setRepeatCount(int count) {

    }

    @Override
    public void removeRepeatCount() {

    }

    @Override
    public void setId(String id) {

    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void addPayload(Map<Payload, Double> payload) {

    }

    @Override
    public void addPayload(Payload payload, double value) {

    }

    @Override
    public void removePayload(Payload payload) {

    }
}
