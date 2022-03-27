package ru.isador.jspe.ui.core;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

@ApplicationScoped
public class RectangleFactory {

    private final IdGenerator idGenerator;
    private Rectangle rectangle;

    @Inject
    public RectangleFactory(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Rectangle newRectangle(double x, double y, double width, double height) {
        rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.LIGHTGRAY);
        rectangle.setStroke(Color.BLACK);
        rectangle.setId(idGenerator.newId(Rectangle.class));

        rectangle.setOnMouseDragged(event -> {
            Rectangle rectangle = (Rectangle) event.getTarget();
            DragData dragData = (DragData) rectangle.getUserData();
            if (dragData == null) {
                dragData = new DragData(event.getX(), event.getY());
                rectangle.setUserData(dragData);
                return;
            }
            rectangle.setX(rectangle.getX() + (event.getX() - dragData.startX));
            rectangle.setY(rectangle.getY() + (event.getY() - dragData.startY));
            dragData.startX = event.getX();
            dragData.startY = event.getY();
        });

        rectangle.setOnMouseReleased(event -> ((Rectangle) event.getTarget()).setUserData(null));

        MenuItem itemRemove = new MenuItem("Remove");
        itemRemove.setUserData(rectangle);
        itemRemove.setOnAction(event -> {
            Rectangle rectangle = (Rectangle) ((MenuItem)event.getSource()).getUserData();
            ((Pane)rectangle.getParent()).getChildren().remove(rectangle);
        });

        ContextMenu contextMenu = new ContextMenu(itemRemove);
        rectangle.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.SECONDARY) {
                contextMenu.show((Node) event.getTarget(), event.getScreenX(), event.getScreenY());
            }
        });
        return rectangle;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    private static class DragData {
        double startX;
        double startY;

        public DragData(double startX, double startY) {
            this.startX = startX;
            this.startY = startY;
        }

        @Override
        public String toString() {
            return "DragData{" +
                   "startX=" + startX +
                   ", startY=" + startY +
                   '}';
        }
    }
}
