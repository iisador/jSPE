package com.isador.jspe.core.nodes;

public interface CaseNode extends Node {

    void setCase(Node child, Double probability);

    void removeCase(Node child);
}
