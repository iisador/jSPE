package ru.isador.jspe.api;

import java.util.Collection;

/**
 * Собсно модель системы.
 *
 * @since 1.0.0
 */
public interface Project {

    String getName();

    void setName(String name);

    Collection<Scenario> getPerformanceScenarios();

    Collection<Scenario> getServiceScenarios();

    Collection<ComputerResourceRequirement> getComputerResourceRequirements();
}
