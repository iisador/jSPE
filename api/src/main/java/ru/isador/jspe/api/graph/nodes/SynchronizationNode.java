package ru.isador.jspe.api.graph.nodes;

import ru.isador.jspe.api.Scenario;
import ru.isador.jspe.api.graph.OverheadMatrix;

/**
 * Синхронизованный узел.
 *
 * @since 1.0.0
 */
public class SynchronizationNode extends ProcessingNode {

    private PartnerType type;
    private Scenario scenario;
    private SynchronizationNode partner;

    public PartnerType getType() {
        return type;
    }

    public void setType(PartnerType type) {
        this.type = type;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public SynchronizationNode getPartner() {
        return partner;
    }

    public void setPartner(SynchronizationNode partner) {
        this.partner = partner;
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
