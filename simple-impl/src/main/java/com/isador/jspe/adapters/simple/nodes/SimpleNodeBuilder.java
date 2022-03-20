package com.isador.jspe.adapters.simple.nodes;

import com.isador.jspe.core.Payload;
import com.isador.jspe.core.SpeModel;
import com.isador.jspe.core.nodes.NodeBuilder;
import com.isador.jspe.core.nodes.Types;

public class SimpleNodeBuilder implements NodeBuilder<AbstractNode> {

    private final AbstractNode node;

    private SimpleNodeBuilder(AbstractNode node) {
        this.node = node;
    }

    public static SimpleNodeBuilder ofType(Types nodeType) {
        return switch (nodeType) {
            case BASIC -> basicNodeBuilder();
            case CASE ->  caseNodeBuilder();
            case EXPANDED -> expandedNodeBuilder();
            case PARDO -> pardoNodeBuilder();
            case REPETITION -> repetitionNodeBuilder();
            case SPLIT -> splitNodeBuilder();
        };
    }

    public static SimpleNodeBuilder basicNodeBuilder() {
        return new SimpleNodeBuilder(new SimpleBasicNode());
    }

    public static SimpleNodeBuilder caseNodeBuilder() {
        return new SimpleNodeBuilder(new SimpleCaseNode());
    }

    public static SimpleNodeBuilder expandedNodeBuilder() {
        return new SimpleNodeBuilder(new SimpleExpandedNode());
    }

    public static SimpleNodeBuilder pardoNodeBuilder() {
        return new SimpleNodeBuilder(new SimplePardoNode());
    }

    public static SimpleNodeBuilder repetitionNodeBuilder() {
        return new SimpleNodeBuilder(new SimpleRepetitionNode());
    }

    public static SimpleNodeBuilder splitNodeBuilder() {
        return new SimpleNodeBuilder(new SimpleSplitNode());
    }

    @Override
    public AbstractNode build() {
        return node;
    }

    @Override
    public SimpleNodeBuilder addCase(AbstractNode step, double probability) {
        ((SimpleCaseNode) node).addChild(step);
        ((SimpleCaseNode) node).setProbability(step.getId(), probability);
        return this;
    }

    @Override
    public SimpleNodeBuilder removeCase(AbstractNode child) {
        ((SimpleCaseNode) node).removeChild(child);
        ((SimpleCaseNode) node).removeProbability(child.getId());
        return this;
    }

    @Override
    public NodeBuilder<AbstractNode> setModel(SpeModel<AbstractNode> model) {
        ((SimpleExpandedNode) node).setModel(model);
        return this;
    }

    @Override
    public SimpleNodeBuilder removeModel() {
        ((SimpleExpandedNode) node).removeModel();
        return this;
    }

    @Override
    public SimpleNodeBuilder addStep(AbstractNode step) {
        ((AbstractCompoundNode) node).addChild(step);
        return this;
    }

    @Override
    public SimpleNodeBuilder removeStep(AbstractNode step) {
        ((AbstractCompoundNode) node).removeChild(step);
        return this;
    }

    @Override
    public SimpleNodeBuilder setRepeatCount(int count) {
        ((SimpleRepetitionNode) node).setRepeatCount(count);
        return this;
    }

    @Override
    public SimpleNodeBuilder removeRepeatCount() {
        ((SimpleRepetitionNode) node).removeRepeatCount();
        return this;
    }

    @Override
    public SimpleNodeBuilder setId(String id) {
        node.setId(id);
        return this;
    }

    @Override
    public SimpleNodeBuilder setTitle(String title) {
        node.setTitle(title);
        return this;
    }

    @Override
    public SimpleNodeBuilder addPayload(Payload payload, double value) {
        node.getPayloadMap().put(payload, value);
        return this;
    }

    @Override
    public SimpleNodeBuilder removePayload(Payload payload) {
        node.getPayloadMap().remove(payload);
        return this;
    }
}
