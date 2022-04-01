package ru.isador.jspe.api.node.processing;

import ru.isador.jspe.api.ExecutionGraph;

public interface ExpandedNode extends ProcessingNode {

    void getExecutionGraph();

    void setExecutionGraph(ExecutionGraph executionGraph);
}
