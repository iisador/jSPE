package ru.isador.jspe.api.nodes;

import ru.isador.jspe.api.Scenario;

public class LinkNode extends ProcessingNode {

    private Scenario scenario;

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
