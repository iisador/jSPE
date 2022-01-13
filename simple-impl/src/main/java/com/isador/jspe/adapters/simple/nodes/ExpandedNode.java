package com.isador.jspe.adapters.simple.nodes;

import java.io.Serial;

import com.isador.jspe.core.SpeModel;

public final class ExpandedNode extends AbstractNode {

    @Serial
    private static final long serialVersionUID = 5920402076314791603L;

    private SpeModel model;

    public SpeModel getModel() {
        return model;
    }

    public void setModel(SpeModel model) {
        this.model = model;
    }
}
