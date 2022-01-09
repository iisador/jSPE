package com.isador.jspe.core.nodes;

import com.isador.jspe.core.SpeModel;

public interface ExpandedNode extends Node {

    void setModel(SpeModel<? extends Node> model);

    SpeModel<? extends Node> getModel();
}
