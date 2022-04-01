package ru.isador.jspe.adapters.simple;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import ru.isador.jspe.api.PerformanceScenario;
import ru.isador.jspe.api.Project;

public class SimpleProject implements Project, Serializable {

    @Serial
    private static final long serialVersionUID = -826848791863138436L;

    private String name;

    @Override
    public String geName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<PerformanceScenario> getPerformanceScenarios() {
        return List.of();
    }

    @Override
    public void addPerformanceScenario(PerformanceScenario performanceScenario) {

    }

    @Override
    public void removePerformanceScenario(PerformanceScenario performanceScenario) {

    }
}
