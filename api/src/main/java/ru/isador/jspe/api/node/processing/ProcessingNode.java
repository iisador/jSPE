package ru.isador.jspe.api.node.processing;

import ru.isador.jspe.api.node.Node;

public interface ProcessingNode extends Node {

    String getType();

    void setType(String type);
}
