package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;
import java.util.Set;

import com.isador.jspe.adapters.simple.AbstractNode;
import com.isador.jspe.core.Matrix;
import com.isador.jspe.core.Payload;
import com.isador.jspe.core.nodes.CaseNode;
import com.isador.jspe.core.nodes.Node;

public final class SimpleCaseNode extends AbstractNode implements CaseNode {

    @Serial
    private static final long serialVersionUID = -1522668239964301791L;

    @Override
    public void setCase(Node child, Double probability) {
    }

    @Override
    public void removeCase(Node child) {
    }

    @Override
    public Matrix<Payload> calculatePayloadMatrix() {
        return null;
    }
}
