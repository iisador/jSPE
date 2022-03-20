package com.isador.jspe.ui;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import javafx.scene.shape.Rectangle;

@ApplicationScoped
public class IdGenerator {

    public String newId(Class<?> clazz) {
        if (clazz == Rectangle.class) {
            return "rect_" + UUID.randomUUID();
        }
        return UUID.randomUUID().toString();
    }
}
