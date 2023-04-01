package ru.isador.jspe.api.graph;

import java.util.UUID;

import ru.isador.jspe.api.graph.nodes.Node;

/**
 * Граф выполнения.
 *
 * @since 1.0.0
 */
public class ExecutionGraph {

    private final String id;
    private final OverheadMatrix overheadMatrix;

    private String name;
    private Node startNode;
    private float deadLine;
    private boolean main;

    public ExecutionGraph() {
        id = UUID.randomUUID().toString();
        overheadMatrix = new OverheadMatrix();
    }

    public String getId() {
        return id;
    }

    public OverheadMatrix getOverheadMatrix() {
        return overheadMatrix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public float getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(float deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public float getAvgTime() {
        return startNode.getAvgTime(overheadMatrix);
    }

    public float getMinTime() {
        return startNode.getMinTime(overheadMatrix);
    }

    public float getMaxTime() {
        return startNode.getMaxTime(overheadMatrix);
    }

    public Node getMaxPath() {
        Node clone = startNode.cloneNode();
        clone.setChild(startNode.getChild().getMaxPath(clone, overheadMatrix));
        return clone;
    }

    public Node getMinPath() {
        Node clone = startNode.cloneNode();
        clone.setChild(startNode.getChild().getMinPath(clone, overheadMatrix));
        return clone;
    }
}
