package ru.isador.jspe.adapters.dirty;

import ru.isador.jspe.api.spi.ProjectFactory;

/**
 * Реализация абстрактной фабрики для элементов модели.
 */
public class DirtyProjectFactory implements ProjectFactory<DirtyProject> {

    @Override
    public DirtyProject create(String name) {
        return null;
    }
}
