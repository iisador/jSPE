package ru.isador.jspe.api.graph.nodes;

import ru.isador.jspe.api.graph.ExecutionGraph;
import ru.isador.jspe.api.graph.OverheadMatrix;

public class ExpandedNode extends ProcessingNode {

    private ExecutionGraph executionGraph;

    public ExecutionGraph getExecutionGraph() {
        return executionGraph;
    }

    public void setExecutionGraph(ExecutionGraph executionGraph) {
        this.executionGraph = executionGraph;
    }

    @Override
    public float getMinTime(OverheadMatrix overheadMatrix) {
        return 0;
    }

    @Override
    public float getMaxTime(OverheadMatrix overheadMatrix) {
        return 0;
    }

    @Override
    public float getAvgTime(OverheadMatrix overheadMatrix) {
        return 0;
    }

    @Override
    public Node getMinPath(Node parent, OverheadMatrix overheadMatrix) {
        return null;
    }

    @Override
    public Node getMaxPath(Node parent, OverheadMatrix overheadMatrix) {
        return null;
    }

    @Override
    public Node cloneNode() {
        return null;
    }
}
