package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;

import com.isador.jspe.adapters.simple.AbstractNode;
import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.Payload;

public final class RepetitionNode extends AbstractNode {

    @Serial
    private static final long serialVersionUID = 6138264215493634608L;

    @Override
    public Matrix<Payload> calculatePayloadMatrix() {
        return null;
    }
}
