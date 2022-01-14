package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;

import com.isador.jspe.adapters.simple.SimpleModel;
import com.isador.jspe.core.SpeModel;

public final class SimpleExpandedNode extends AbstractNode {

    @Serial
    private static final long serialVersionUID = 5920402076314791603L;

    private SpeModel<AbstractNode> model;

    public SpeModel<AbstractNode> getModel() {
        return model;
    }

    public void setModel(SpeModel<AbstractNode> model) {
        this.model = model;
    }

    public void removeModel() {
        this.model = null;
    }
}
