package ru.isador.jspe.api;

import ru.isador.jspe.api.nodes.Node;

/**
 * Дуга, соединяющая два узла.
 *
 * @since 1.0.0
 */
public interface Arc {

    Node getFrom();

    void setFrom(Node from);

    Node getTo();

    void setTo(Node to);
}
