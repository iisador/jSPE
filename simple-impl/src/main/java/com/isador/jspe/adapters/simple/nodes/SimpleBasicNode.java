package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;

import com.isador.jspe.adapters.simple.AbstractNode;
import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.nodes.BasicNode;
import com.isador.jspe.core.nodes.NodeStatistic;

/**
 * Реализация Basic node.
 * Базовый узел модели, который несет полезную нагрузку.
 * Базовый узел должен иметь только одного потомка, либо
 * быть конечным узлом.
 *
 * @since 1.0.0
 */
public final class SimpleBasicNode extends AbstractNode implements BasicNode {

    @Serial
    private static final long serialVersionUID = 2601070160872670175L;

    /**
     * Базовый узел просто суммирует свою нагрузку с нагрузкой
     * потомков.
     *
     * @return суммарная нагрузка с потомком.
     *
     * @since 1.0.0
     */
    @Override
    public Matrix<Payload> calculatePayloadMatrix() {
        if (childList.isEmpty()) {
            return payloadMatrix;
        }
        return payloadMatrix.plus(childList.get(0).calculatePayloadMatrix());
    }

    @Override
    public NodeStatistic getStatistic(ConsumptionMatrix consumptionMatrix) {
        Matrix<Payload> calculatedPayload;
        if (childList.isEmpty()) {
            calculatedPayload = payloadMatrix;
        } else {
            calculatedPayload = payloadMatrix.plus(childList.get(0).calculatePayloadMatrix());
        }
        return null;
    }
}
