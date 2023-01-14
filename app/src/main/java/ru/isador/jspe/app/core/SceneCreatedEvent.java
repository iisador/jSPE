package ru.isador.jspe.app.core;

import javafx.scene.Scene;

/**
 * События создания сцены приложения.
 */
public record SceneCreatedEvent(Scene scene) implements ApplicationEvent {
}
