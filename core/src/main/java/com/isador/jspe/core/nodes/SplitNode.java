package com.isador.jspe.core.nodes;

public interface SplitNode extends Node {

    void addStep(Node step);

    void removeStep(Node step);
}
