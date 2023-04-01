package ru.isador.jspe.api.graph.nodes;

import ru.isador.jspe.api.Scenario;
import ru.isador.jspe.api.graph.OverheadMatrix;

public class LinkNode extends ProcessingNode {

    private Scenario scenario;

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
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
