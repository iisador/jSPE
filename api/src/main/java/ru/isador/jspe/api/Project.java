package ru.isador.jspe.api;

import java.util.Collection;

public interface Project extends Named {

    Collection<PerformanceScenario> getPerformanceScenarios();

    void addPerformanceScenario(PerformanceScenario performanceScenario);

    void removePerformanceScenario(PerformanceScenario performanceScenario);
}
