package ru.isador.jspe.api;

import ru.isador.jspe.api.node.Node;

public interface Arc {

    Node getFrom();

    void setFrom(Node node);

    Node getTo();

    void setTo(Node node);
}
