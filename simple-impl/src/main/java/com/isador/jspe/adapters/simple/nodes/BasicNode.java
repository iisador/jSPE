package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;
import java.util.Map;

import com.isador.jspe.adapters.simple.Payload;

/**
 * Реализация Basic node.
 * Базовый узел модели, который несет полезную нагрузку.
 * Базовый узел должен иметь только одного потомка, либо
 * быть конечным узлом.
 *
 * @since 1.0.0
 */
public final class BasicNode extends AbstractNode {

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
    public Map<Payload, Double> calculatePayloadMatrix() {
        return next == null ? payloadMap : plus(payloadMap, next.calculatePayloadMatrix());
    }
}
