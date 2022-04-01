package ru.isador.jspe.api.node.comound;

import java.util.Collection;

import ru.isador.jspe.api.Arc;
import ru.isador.jspe.api.node.Node;
import ru.isador.jspe.api.node.processing.ProcessingNode;

public interface CompoundNode extends Node {

    Collection<ProcessingNode> getNodes();

    void addNode(ProcessingNode node);

    void removeNode(ProcessingNode node);

    Collection<Arc> getArcs();

    void addArc(Arc arc);

    void removeArc(Arc arc);
}
