package ru.isador.jspe.core;

import java.util.Optional;

import ru.isador.jspe.core.nodes.Node;

public interface ModelError {

    String getMessage();

    Optional<Node> getProblemNode();
}
