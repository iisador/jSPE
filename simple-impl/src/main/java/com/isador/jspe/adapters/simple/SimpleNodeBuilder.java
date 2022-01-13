package com.isador.jspe.adapters.simple;

import java.util.Map;

import com.isador.jspe.adapters.simple.nodes.AbstractNode;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.SpeModel;
import com.isador.jspe.core.nodes.NodeBuilder;

public class SimpleNodeBuilder implements NodeBuilder<AbstractNode> {

    @Override
    public AbstractNode build() {
        return null;
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
    public void setPayload(Map<Payload, Double> payload) {

    }

    @Override
    public Map<Payload, Double> addPayload(Payload payload, double value) {
        return null;
    }

    @Override
    public void removePayload(Payload payload) {

    }
}
