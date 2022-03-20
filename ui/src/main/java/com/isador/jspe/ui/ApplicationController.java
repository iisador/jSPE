package com.isador.jspe.ui;

import com.isador.jspe.ui.core.RectangleFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

@ApplicationScoped
public class ApplicationController {

    private RectangleFactory rectangleFactory;

    public void onMouseEvent(MouseEvent e) {
        if(e.getTarget().getClass() != Pane.class) {
            return;
        }

        if (MouseEvent.MOUSE_PRESSED.equals(e.getEventType())) {
            Pane n = (Pane) e.getTarget();
            n.getChildren().add(rectangleFactory.newRectangle(e.getX(), e.getY(), 1.0, 1.0));
        }

        if (MouseEvent.MOUSE_DRAGGED.equals(e.getEventType())) {
            if (e.getX() < rectangleFactory.getRectangle().getX()) {
                rectangleFactory.getRectangle().setX(e.getX());
            }
            if (e.getY() < rectangleFactory.getRectangle().getY()) {
                rectangleFactory.getRectangle().setY(e.getY());
            }
            rectangleFactory.getRectangle().setWidth(Math.abs(e.getX() - rectangleFactory.getRectangle().getX()));
            rectangleFactory.getRectangle().setHeight(Math.abs(e.getY() - rectangleFactory.getRectangle().getY()));
        }
    }

    @Inject
    public void setRectangleFactory(RectangleFactory rectangleFactory) {
        this.rectangleFactory = rectangleFactory;
    }
}
