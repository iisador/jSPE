package ru.isador.jspe.api;

import java.time.Duration;

public interface PerformanceScenario extends Named {

    Duration getIntervalTime();

    void setIntervalTime(Duration intervalTime);

    Integer getNumberOfJobs();

    void setNumberOfJobs(Integer numberOfJobs);

    Integer getPriority();

    void setPriority(Integer priority);

    ExecutionGraph getExecutionGraph();

    void setExecutionGraph(ExecutionGraph executionGraph);
}
