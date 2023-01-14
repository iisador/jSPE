package ru.isador.jspe.api.spi;

import ru.isador.jspe.api.Project;

public interface ProjectFactory {

    Project create(String name);
}
