package com.isador.jspe.core;

import java.util.Optional;

import com.isador.jspe.core.nodes.Node;

public interface ModelError {

    String getMessage();

    Optional<Node> getProblemNode();
}
