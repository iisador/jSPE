package ru.isador.jspe.api.nodes;

import ru.isador.jspe.api.ExecutionGraph;

public class ExpandedNode extends ProcessingNode {

    private ExecutionGraph executionGraph;

    public ExecutionGraph getExecutionGraph() {
        return executionGraph;
    }

    public void setExecutionGraph(ExecutionGraph executionGraph) {
        this.executionGraph = executionGraph;
    }
}
