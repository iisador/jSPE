package ru.isador.jspe.app;

import java.util.ResourceBundle;
import java.util.ServiceLoader;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import ru.isador.jspe.api.spi.ProjectFactory;

/**
 * Провайдер бинов для приложения.
 */
@ApplicationScoped
public class GlobalBeanProvider {

    @Produces
    public ResourceBundle getResources() {
        return ResourceBundle.getBundle("ru.isador.jspe.app.i18n");
    }

    @Produces
    public ProjectFactory getProjectFactory() {
        return ServiceLoader.load(ProjectFactory.class).findFirst().orElseThrow();
    }
}
