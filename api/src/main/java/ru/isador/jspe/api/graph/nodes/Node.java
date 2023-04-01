package ru.isador.jspe.api.graph.nodes;

import ru.isador.jspe.api.graph.OverheadMatrix;
import ru.isador.jspe.api.graph.SoftwareResourceRequirements;

public interface Node {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    SoftwareResourceRequirements getSoftwareResourceRequirements();

    Node getChild();

    void setChild(Node child);

    Node getParent();

    void setParent(Node parent);

    float getMinTime(OverheadMatrix overheadMatrix);

    float getMaxTime(OverheadMatrix overheadMatrix);

    float getAvgTime(OverheadMatrix overheadMatrix);

    Node getMinPath(Node parent, OverheadMatrix overheadMatrix);

    Node getMaxPath(Node parent, OverheadMatrix overheadMatrix);

    Node cloneNode();

    String toString(OverheadMatrix overheadMatrix);
}
