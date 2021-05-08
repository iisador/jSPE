package com.isador.jspe.core.impls.simple;

import java.io.Serializable;

import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.OverheadMatrix;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.Resource;

import static java.util.Objects.requireNonNull;

public class SimpleOverheadMatrix implements OverheadMatrix, Serializable {

    private Matrix<Payload> payloadMatrix;
    private Matrix<Resource> resourceMatrix;

    @Override
    public Matrix<Payload> getPayloadMatrix() {
        return payloadMatrix;
    }

    public void setPayloadMatrix(Matrix<Payload> payloadMatrix) {
        this.payloadMatrix = requireNonNull(payloadMatrix);
    }

    @Override
    public Matrix<Resource> getResourceMatrix() {
        return resourceMatrix;
    }

    public void setResourceMatrix(Matrix<Resource> resourceMatrix) {
        this.resourceMatrix = requireNonNull(resourceMatrix);
    }

    @Override
    public Long getServiceTime() {
        return resourceMatrix.entrySet().stream()
                .map(e -> e.getKey().getServiceTime() / e.getValue())
                .reduce(0.0, Double::sum)
                .longValue();
    }
}
