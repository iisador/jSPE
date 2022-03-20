package com.isador.jspe.ui;

import javafx.css.Styleable;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class GlobalMouseEventHandler implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        Scene scene = (Scene) event.getSource();
        var n = event.getTarget();

        String mousePos = getMousePos(event);
        if (n instanceof Styleable) {
            setLabelText(scene, mousePos + String.format("; Class: %s; Id: %s", n.getClass().getName(), ((Styleable) n).getId()));
        } else {
            setLabelText(scene, mousePos + String.format("; Class: %s", n.getClass().getName()));
        }
    }

    private void setLabelText(Scene scene, String text) {
        ((Label) scene.lookup("#elem")).setText(text);
    }

    private String getMousePos(MouseEvent event) {
        return String.format("(%s, %s)", event.getX(), event.getY());
    }
}
