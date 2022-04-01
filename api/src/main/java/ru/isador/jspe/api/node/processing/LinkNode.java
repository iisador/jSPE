package ru.isador.jspe.api.node.processing;

import ru.isador.jspe.api.PerformanceScenario;

public interface LinkNode extends ProcessingNode {

    PerformanceScenario getPerformanceScenario();

    void setPerformanceScenario(PerformanceScenario performanceScenario);
}
