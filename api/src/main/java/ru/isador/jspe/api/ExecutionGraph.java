package ru.isador.jspe.api;

import java.time.LocalDateTime;
import java.util.Collection;

import ru.isador.jspe.api.node.Node;

public interface ExecutionGraph extends Named {

    String getDescription();

    void setDescription(String description);

    LocalDateTime getModificationDatetime();

    void setModificationDatetime(LocalDateTime modificationDatetime);

    boolean isMainEG();

    void setMainEG(boolean mainEG);

    Node getStartNode();

    void setStartNode(Node node);

    Collection<Node> getNodes();

    void addNode(Node node);

    void removeNode(Node node);

    Collection<Arc> getArcs();

    void addArc(Arc arc);

    void removeArc(Arc arc);
}
