package ru.isador.jspe.app.core;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import javafx.scene.shape.Rectangle;

/**
 * Генератор айдишников.
 */
@ApplicationScoped
public class IdGenerator {

    /**
     * Сгенерировать айдишник по классу.
     *
     * @param clazz класс объекта.
     *
     * @return сгенерированный айдишник.
     */
    public String newId(Class<?> clazz) {
        if (clazz == Rectangle.class) {
            return "rect_" + UUID.randomUUID();
        }
        return UUID.randomUUID().toString();
    }
}
