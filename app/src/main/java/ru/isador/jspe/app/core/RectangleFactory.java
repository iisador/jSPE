package ru.isador.jspe.app.core;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

/**
 * Фабрика создания кирпичей.
 */
@ApplicationScoped
public class RectangleFactory {

    private static final Pattern P = Pattern.compile("^\\s*<path d=\"([\\d-,mlz]*)\" .*");
    private final IdGenerator idGenerator;

    @Inject
    public RectangleFactory(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    /**
     * Создание кирпича.
     *
     * @param x      x.
     * @param y      y.
     * @param width  длина.
     * @param height высота.
     *
     * @return кирпич блять.
     */
    public Node newRectangle(double x, double y, double width, double height) {
        Rectangle border = new Rectangle(width, height);
        border.getStyleClass().add("shape-border");

        SVGPath shape = new SVGPath();
        shape.setContent(getSvgPath("1"));
        shape.setId(idGenerator.newId(Node.class));
        shape.getStyleClass().add("shape");

        Group group = new Group(shape, border);
        group.setLayoutX(x);
        group.setLayoutY(y);
        group.setOnMouseDragged(event -> {
            Node rectangle = (Node) event.getTarget();
            DragData dragData = (DragData) rectangle.getUserData();
            if (dragData == null) {
                dragData = new DragData(event.getX(), event.getY());
                rectangle.setUserData(dragData);
                return;
            }
            rectangle.setLayoutX(rectangle.getLayoutX() + (event.getX() - dragData.startX));
            rectangle.setLayoutY(rectangle.getLayoutY() + (event.getY() - dragData.startY));
            dragData.startX = event.getX();
            dragData.startY = event.getY();
        });

        group.setOnMouseReleased(event -> ((Node) event.getTarget()).setUserData(null));

        MenuItem itemRemove = new MenuItem("Remove");
        itemRemove.setUserData(shape);
        itemRemove.setOnAction(event -> {
            Node rectangle = (Node) ((MenuItem) event.getSource()).getUserData();
            ((Pane) rectangle.getParent().getParent()).getChildren().remove(rectangle);
        });

        ContextMenu contextMenu = new ContextMenu(itemRemove);
        group.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                contextMenu.show((Node) event.getTarget(), event.getScreenX(), event.getScreenY());
            }
        });
        return group;
    }

    private String getSvgPath(String figureName) {
        try {
            URL figureUrl = getClass().getResource("figures/" + figureName + ".svg");
            String pathLine = Files.readAllLines(Paths.get(figureUrl.toURI())).stream()
                    .filter(line -> line.matches(P.toString()))
                    .findFirst()
                    .orElse(null);
            Matcher m = P.matcher(pathLine);
            if (m.find()) {
                return m.group(1);
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return null;
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
