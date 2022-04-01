package ru.isador.jspe.ui;

import java.util.ResourceBundle;
import java.util.ServiceLoader;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import ru.isador.jspe.api.ProjectFactory;

@ApplicationScoped
public class GlobalBeanProvider {

    @Produces
    public ResourceBundle getResources() {
        return ResourceBundle.getBundle("ru.isador.jspe.ui.i18n");
    }

    @Produces
    public ProjectFactory getProjectFactory() {
        return ServiceLoader.load(ProjectFactory.class).findFirst().orElseThrow();
    }
}
