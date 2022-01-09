package com.isador.jspe.core.nodes;

import java.io.Serializable;

import com.isador.jspe.core.ConsumptionMatrix;
import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.Payload;

/**
 * Интерфейс, описывающий узел модели.
 *
 * @since 1.0.0
 */
public interface Node extends Serializable {

    /**
     * Каждый узел должен иметь ID.
     *
     * @since 1.0.0
     */
    String getId();

    /**
     * Краткое описание узла.
     *
     * @return Реализация по умолчанию вернёт {@code Optional.empty()}.
     *
     * @since 1.0.0
     */
    String getTitle();

    /**
     * Матрица потребления узла.
     *
     * @return матрица потребления.
     *
     * @since 1.0.0
     */
    Matrix<Payload> getPayloadMatrix();

    NodeStatistic getStatistic(ConsumptionMatrix consumptionMatrix);
}
