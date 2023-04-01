package ru.isador.jspe.api.spi;

import ru.isador.jspe.api.Project;

public interface ProjectFactory<T extends Project> {

    T create(String name);
}
