package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;

import com.isador.jspe.core.Payload;

public class TestNode extends AbstractNode {

    @Serial
    private static final long serialVersionUID = -7415080468148024740L;

    private final boolean valid;

    public TestNode(boolean valid) {
        this.valid = valid;
    }

    public TestNode() {
        valid = true;
    }

    @Override
    public Matrix<Payload> calculatePayloadMatrix() {
        return Matrix.emptyMatrix();
    }
}
