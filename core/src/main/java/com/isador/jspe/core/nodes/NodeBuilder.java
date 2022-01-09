package com.isador.jspe.core.nodes;

import com.isador.jspe.core.SpeModel;

public interface NodeBuilder {

    NodeBuilder withName(String name);

    NodeBuilder withId(String id);

    NodeBuilder withProbability(Node node, Double probability);

    NodeBuilder withModel(SpeModel<? extends Node> model);

    NodeBuilder withRepeatCount(Integer count);
}
