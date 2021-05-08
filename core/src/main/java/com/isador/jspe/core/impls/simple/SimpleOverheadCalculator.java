package com.isador.jspe.core.impls.simple;

import java.util.AbstractMap.SimpleEntry;

import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.OverheadCalculator;
import com.isador.jspe.core.OverheadMatrix;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.Resource;
import com.isador.jspe.core.impls.simple.nodes.AbstractNode;

public class SimpleOverheadCalculator implements OverheadCalculator<AbstractNode> {

    @Override
    public OverheadMatrix calculate(ConsumptionMatrix consumptionMatrix, AbstractNode rootNode) {
        SimpleOverheadMatrix overheadMatrix = new SimpleOverheadMatrix();
        Matrix<Payload> payloadMatrix = rootNode.calculatePayloadMatrix();
        overheadMatrix.setPayloadMatrix(payloadMatrix);
        Matrix<Resource> resourceMatrix = new SimpleMatrix<>();

        payloadMatrix.forEach((payload, payloadConsumption) -> consumptionMatrix.getMappedResources(payload).stream()
                .map(resource -> new SimpleEntry<>(resource, consumptionMatrix.getConsumption(payload, resource) * payloadConsumption))
                .forEach(e -> resourceMatrix.merge(e.getKey(), e.getValue(), Double::sum)));

        overheadMatrix.setResourceMatrix(resourceMatrix);
        return overheadMatrix;
    }
}
