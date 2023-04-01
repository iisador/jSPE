package ru.isador.jspe.adapters.dirty;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import ru.isador.jspe.api.graph.ExecutionGraph;
import ru.isador.jspe.api.facility.Facility;
import ru.isador.jspe.api.PerformanceScenario;
import ru.isador.jspe.api.facility.distributions.Distribution;

/**
 * @since 1.0.0
 */
public class DirtyPerformanceScenario implements PerformanceScenario, Serializable {

    @Serial
    private static final long serialVersionUID = -2164091773938888691L;

    private final Collection<ExecutionGraph> executionGraphs;
    private String id;
    private String name;
    private Distribution arrivalDistribution;
    private float interarrivalTime;
    private long numberOfJobs;
    private long numberOfInstances;
    private float responseTimeRequirement;
    private float throughputRequirement;
    private int priority;
    private Facility facility;

    public DirtyPerformanceScenario() {
        executionGraphs = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Distribution getArrivalDistribution() {
        return arrivalDistribution;
    }

    public void setArrivalDistribution(Distribution arrivalDistribution) {
        this.arrivalDistribution = arrivalDistribution;
    }

    public Collection<ExecutionGraph> getExecutionGraphs() {
        return executionGraphs;
    }

    @Override
    public ExecutionGraph getMainGraph() {
        return executionGraphs.stream()
                .filter(ExecutionGraph::isMain)
                .findFirst()
                .orElse(null);
    }

    public float getInterarrivalTime() {
        return interarrivalTime;
    }

    public void setInterarrivalTime(float interarrivalTime) {
        this.interarrivalTime = interarrivalTime;
    }

    public long getNumberOfJobs() {
        return numberOfJobs;
    }

    public void setNumberOfJobs(long numberOfJobs) {
        this.numberOfJobs = numberOfJobs;
    }

    public long getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(long numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public float getResponseTimeRequirement() {
        return responseTimeRequirement;
    }

    public void setResponseTimeRequirement(float responseTimeRequirement) {
        this.responseTimeRequirement = responseTimeRequirement;
    }

    public float getThroughputRequirement() {
        return throughputRequirement;
    }

    public void setThroughputRequirement(float throughputRequirement) {
        this.throughputRequirement = throughputRequirement;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
