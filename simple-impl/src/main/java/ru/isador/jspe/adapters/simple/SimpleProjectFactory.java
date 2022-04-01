package ru.isador.jspe.adapters.simple;

import ru.isador.jspe.api.Project;

public class SimpleProjectFactory implements ru.isador.jspe.api.ProjectFactory {

    @Override
    public Project createProject() {
        return new SimpleProject();
    }
}
