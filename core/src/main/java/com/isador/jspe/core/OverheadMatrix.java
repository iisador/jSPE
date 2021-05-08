package com.isador.jspe.core;

/**
 * Матрица накладных расходов.
 * Содержит общее количество полезной нагрузки и потребления ресурсов.
 * Также позволяет вычислить время обслуживания исходя из потребляемых ресурсов.
 *
 * @since 1.0.0
 */
public interface OverheadMatrix {

    Matrix<Payload> getPayloadMatrix();

    Matrix<Resource> getResourceMatrix();

    Long getServiceTime();
}
