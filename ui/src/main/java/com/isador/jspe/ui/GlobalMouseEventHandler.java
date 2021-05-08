package com.isador.jspe.ui;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class GlobalMouseEventHandler implements EventHandler<MouseEvent> {

    private static final String STR = "getSceneX(): %s; getSceneY(): %s; getX(): %s; getY(): %s";

    private Label label;

    private Label label2;

    private Scene scene;

    public GlobalMouseEventHandler(Label label, Label label2, Scene scene) {
        this.label = label;
        this.label2 = label2;
        this.scene = scene;
    }

    @Override
    public void handle(MouseEvent event) {
        label.setText(String.format(STR, event.getSceneX(), event.getSceneY(), event.getX(), event.getY()));

        var n = event.getTarget();
        label2.setText(n == null ? "null" : n.getClass().getName());

        if (n instanceof Node) {
            if ("right".equals(((Node) n).getId())) {
                label2.setText("" + Math.abs(event.getX() - ((Node) n).getLayoutX()));
                if (Math.abs(event.getX() - ((Node) n).getLayoutX()) < 6) {
                    scene.setCursor(Cursor.H_RESIZE);
                }
            } else {
                if (scene.getCursor() != null) {
                    scene.setCursor(null);
                }
            }
        }
    }
}
