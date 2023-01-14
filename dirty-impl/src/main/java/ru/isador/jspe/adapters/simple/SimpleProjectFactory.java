package ru.isador.jspe.adapters.simple;

import ru.isador.jspe.api.ExecutionGraph;
import ru.isador.jspe.api.Project;
import ru.isador.jspe.api.Scenario;
import ru.isador.jspe.api.spi.ProjectFactory;

/**
 * Реализация абстрактной фабрики для элементов модели.
 */
public class SimpleProjectFactory implements ProjectFactory {

    @Override
    public Project create(String name) {
        ExecutionGraph eg = new SimpleExecutionGraph();
        eg.setId("main");
        eg.setName("main");

        Scenario s = new SimpleScenario();
        s.setId("main");
        s.setName("main");
        s.setMainGraph(eg);
        s.getExecutionGraphs().add(eg);

        Project p = new SimpleProject(name);
        p.getPerformanceScenarios().add(s);
        return p;
    }
}
