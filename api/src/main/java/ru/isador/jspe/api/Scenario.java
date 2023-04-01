package ru.isador.jspe.api;

import java.util.Collection;

import ru.isador.jspe.api.facility.Facility;
import ru.isador.jspe.api.facility.distributions.Distribution;
import ru.isador.jspe.api.graph.ExecutionGraph;

/**
 * Сценарий выполнения.
 * Тут по идее должно быть два класса:
 * PerformanceScenario: представляет собой конкретный use case
 * ServiceScenario: сценарий для PerformanceScenario.
 *
 * @since 1.0.0
 */
public interface Scenario {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    Distribution getArrivalDistribution();

    void setArrivalDistribution(Distribution arrivalDistribution);

    Collection<ExecutionGraph> getExecutionGraphs();

    ExecutionGraph getMainGraph();

    float getInterarrivalTime();

    void setInterarrivalTime(float interarrivalTime);

    long getNumberOfJobs();

    void setNumberOfJobs(long numberOfJobs);

    long getNumberOfInstances();

    void setNumberOfInstances(long numberOfInstances);

    float getResponseTimeRequirement();

    void setResponseTimeRequirement(float responseTimeRequirement);

    float getThroughputRequirement();

    void setThroughputRequirement(float throughputRequirement);

    int getPriority();

    void setPriority(int priority);

    Facility getFacility();

    void setFacility(Facility facility);
}
