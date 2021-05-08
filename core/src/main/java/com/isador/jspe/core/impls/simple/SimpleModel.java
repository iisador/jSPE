package com.isador.jspe.core.impls.simple;

import java.util.Iterator;
import java.util.Optional;
import java.util.stream.StreamSupport;

import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.InvalidModelException;
import com.isador.jspe.core.Model;
import com.isador.jspe.core.Node;
import com.isador.jspe.core.OverheadCalculator;
import com.isador.jspe.core.OverheadMatrix;

public class SimpleModel implements Model {

    private Node rootNode;
    private OverheadCalculator<Node> overheadCalculator;
    private ConsumptionMatrix consumptionMatrix;

    public SimpleModel() {
        consumptionMatrix = new SimpleConsumptionMatrix();
    }

    public SimpleModel(OverheadCalculator<Node> overheadCalculator) {
        this.overheadCalculator = overheadCalculator;
    }

    @Override
    public Optional<Node> getNode(String id) {
        return StreamSupport.stream(spliterator(), false)
                .filter(node -> node.getId().equals(id))
                .findFirst();
    }

    @Override
    public void addNode(Node node) {
        rootNode = node;
    }

    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }

    @Override
    public ConsumptionMatrix getConsumptionMatrix() {
        return consumptionMatrix;
    }

    public void setConsumptionMatrix(ConsumptionMatrix consumptionMatrix) {
        this.consumptionMatrix = consumptionMatrix;
    }

    @Override
    public OverheadMatrix getOverheadMatrix() {
        return overheadCalculator.calculate(consumptionMatrix, rootNode);
    }

    public void setOverheadCalculator(OverheadCalculator<Node> overheadCalculator) {
        this.overheadCalculator = overheadCalculator;
    }

    @Override
    public void validate() throws InvalidModelException {
        NodesIterator it = new NodesIterator(rootNode);

        while (it.hasNext()) {
            var n = it.next();
            if (!n.isValid()) {
                throw new InvalidModelException(n);
            }
        }

        it.getCyclicNode()
                .ifPresent(n -> {
                    throw new InvalidModelException(n, "Model has cyclic dependencies");
                });
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodesIterator(rootNode);
    }
}
