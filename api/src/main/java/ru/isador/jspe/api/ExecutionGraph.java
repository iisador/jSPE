package ru.isador.jspe.api;

import java.time.LocalDateTime;
import java.util.Collection;

import ru.isador.jspe.api.nodes.Node;

/**
 * Граф выполнения.
 *
 * @since 1.0.0
 */
public interface ExecutionGraph {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    Collection<Node> getNodes();

    Collection<Arc> getArcs();

    Node getStartNode();

    void setStartNode(Node startNode);

    LocalDateTime getModificationDateTime();

    void setModificationDateTime(LocalDateTime modificationDateTime);

    float getDeadline();

    void setDeadline(float deadline);
}
