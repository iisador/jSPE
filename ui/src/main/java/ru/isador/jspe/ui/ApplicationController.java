package ru.isador.jspe.ui;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import ru.isador.jspe.api.Project;
import ru.isador.jspe.ui.core.RectangleFactory;

@ApplicationScoped
public class ApplicationController {

    private RectangleFactory rectangleFactory;
    private Project currentProject;

    private Event<Project> eventNewProject;

    private TabPane projectTabPane;

    private void onSceneCreated(@Observes Scene scene) {
        projectTabPane = (TabPane) scene.lookup("#projectPane");

        projectTabPane.selectionModelProperty().addListener((observable, oldValue, newValue) -> {

        });
    }

    @Inject
    public void setEventNewProject(Event<Project> eventNewProject) {
        this.eventNewProject = eventNewProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
        eventNewProject.fire(currentProject);
        projectTabPane.getTabs().add(newProjectTab(currentProject));
        projectTabPane.getSelectionModel().selectLast();
    }

    private Tab newProjectTab(Project currentProject) {
        Pane projectPane = new Pane();
        projectPane.setId("projectPane_" + currentProject.geName());
        projectPane.setOnMouseDragged(this::onMouseEvent);
        projectPane.setOnMousePressed(this::onMouseEvent);

        Tab projectTab = new Tab(currentProject.geName(), projectPane);
        projectTab.setId("projectTab_" + currentProject.geName());
        return projectTab;
    }

    public void onMouseEvent(MouseEvent e) {
        if (e.getTarget().getClass() != Pane.class) {
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
