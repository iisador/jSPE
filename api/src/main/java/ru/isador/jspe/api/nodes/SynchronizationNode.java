package ru.isador.jspe.api.nodes;

import ru.isador.jspe.api.Scenario;

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
}
