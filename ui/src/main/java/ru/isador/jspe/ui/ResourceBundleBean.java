package ru.isador.jspe.ui;

import java.util.ResourceBundle;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ResourceBundleBean {

    @Produces
    public ResourceBundle getResources() {
        return ResourceBundle.getBundle("ru.isador.jspe.ui.i18n");
    }
}
