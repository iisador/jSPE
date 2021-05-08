package com.isador.jspe.core.impls.simple.nodes;

import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.Payload;

/**
 * Реализация Basic node.
 * Базовый узел модели, который несет полезную нагрузку.
 * Базовый узел должен иметь только одного потомка, либо
 * быть конечным узлом.
 *
 * @since 1.0.0
 */
public final class BasicNode extends AbstractNode {

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
        return payloadMatrix.plus(((AbstractNode) childList.get(0)).calculatePayloadMatrix());
    }

    /**
     * Проверка валидности узла.
     *
     * @return true если узел имеет одного потомка, либо не имеет их вовсе, false в другом случае.
     *
     * @since 1.0.0
     */
    @Override
    public boolean isValid() {
        return childList.size() < 2;
    }
}
