package com.isador.jspe.core;

public class InvalidModelException extends RuntimeException {

    private final Node problemNode;

    public InvalidModelException(Node problemNode) {
        this.problemNode = problemNode;
    }

    public InvalidModelException(Node problemNode, String message) {
        super(message);
        this.problemNode = problemNode;
    }

    public Node getProblemNode() {
        return problemNode;
    }
}
