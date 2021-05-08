package com.isador.jspe.ui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class SceneController {

    private static int rgb = 0;

    Rectangle r;
    double startX;
    double startY;

    @FXML
    private Label label;

    @FXML
    private Label label2;

    private Scene scene;

    public void onMouseEvent(MouseEvent e) {
        if (MouseEvent.MOUSE_PRESSED.equals(e.getEventType())) {
            startX = e.getX();
            startY = e.getY();
            r = new Rectangle(startX, startY, 1.0, 1.0);
            Pane n = (Pane) e.getSource();
            n.getChildren().add(r);
        }

        if (MouseEvent.MOUSE_DRAGGED.equals(e.getEventType())) {
            if (e.getX() < startX) {
                r.setX(e.getX());
            }
            if (e.getY() < startY) {
                r.setY(e.getY());
            }
            r.setWidth(Math.abs(e.getX() - startX));
            r.setHeight(Math.abs(e.getY() - startY));
        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void init() {
        scene.addEventFilter(MouseEvent.ANY, new GlobalMouseEventHandler(label, label2, scene));
        scene.heightProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue));
    }
}
