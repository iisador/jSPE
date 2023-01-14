package ru.isador.jspe.adapters.simple;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import ru.isador.jspe.api.Arc;
import ru.isador.jspe.api.ExecutionGraph;
import ru.isador.jspe.api.nodes.Node;

/**
 * Граф выполнения.
 *
 * @since 1.0.0
 */
public class SimpleExecutionGraph implements ExecutionGraph, Serializable {

    private final Collection<Node> nodes;
    private final Collection<Arc> arcs;
    private String id;
    private String name;
    private Node startNode;
    private LocalDateTime modificationDateTime;
    private float deadline;

    public SimpleExecutionGraph() {
        nodes = new ArrayList<>();
        arcs = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Node> getNodes() {
        return nodes;
    }

    public Collection<Arc> getArcs() {
        return arcs;
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public LocalDateTime getModificationDateTime() {
        return modificationDateTime;
    }

    public void setModificationDateTime(LocalDateTime modificationDateTime) {
        this.modificationDateTime = modificationDateTime;
    }

    public float getDeadline() {
        return deadline;
    }

    public void setDeadline(float deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleExecutionGraph that = (SimpleExecutionGraph) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
