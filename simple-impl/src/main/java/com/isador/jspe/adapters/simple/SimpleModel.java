package com.isador.jspe.adapters.simple;

import java.io.Serial;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.StreamSupport;

import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.InvalidModelException;
import com.isador.jspe.core.SpeModel;
import com.isador.jspe.core.ModelStatistic;
import com.isador.jspe.core.SimpleConsumptionMatrix;
import com.isador.jspe.core.StatisticCalculator;

public class SimpleModel implements SpeModel<AbstractNode> {

    @Serial
    private static final long serialVersionUID = -7230677770877873149L;

    private AbstractNode rootNode;
    private final ConsumptionMatrix consumptionMatrix;
    private final StatisticCalculator<SimpleModel> statisticCalculator;

    public SimpleModel() {
        consumptionMatrix = new SimpleConsumptionMatrix();
        statisticCalculator = new SimpleStatisticCalculator();
    }

    @Override
    public Optional<AbstractNode> getNode(String id) {
        return StreamSupport.stream(spliterator(), false)
                .filter(node -> node.getId().equals(id))
                .findFirst();
    }

    @Override
    public void addNode(AbstractNode node) {
        rootNode = node;
    }

    @Override
    public void addNode(AbstractNode parent, AbstractNode child) {
        getNode(parent.getId())
                .ifPresent(n -> n.addChild(child));
    }

    @Override
    public Optional<AbstractNode> getNode() {
        return Optional.ofNullable(rootNode);
    }

    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }

    @Override
    public ConsumptionMatrix getConsumptionMatrix() {
        return consumptionMatrix;
    }

    @Override
    public ModelStatistic getStatistic() {
        return statisticCalculator.calculateStatistic(this);
    }

    @Override
    public void validate() throws InvalidModelException {
//        new NodesIterator(rootNode).getCyclicNode()
//                .ifPresent(n -> {
//                    throw new InvalidModelException(n, "Model has cyclic dependencies");
//                });
    }

    @Override
    public Iterator<AbstractNode> iterator() {
        return new NodesIterator(rootNode);
    }
}
