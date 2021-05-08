package com.isador.jspe.core.impls.simple.nodes;

import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.Payload;

import static com.isador.jspe.core.Matrix.emptyMatrix;

public class TestNode extends AbstractNode {

    private final boolean valid;

    public TestNode(boolean valid) {
        this.valid = valid;
    }

    public TestNode() {
        valid = true;
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public Matrix<Payload> calculatePayloadMatrix() {
        return emptyMatrix();
    }
}
