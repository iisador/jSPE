package ru.isador.jspe.app.core;

import ru.isador.jspe.api.Project;

/**
 * События создания нового проекта.
 */
public record NewProjectEvent(Project project) implements ApplicationEvent {

}
