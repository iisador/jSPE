package ru.isador.jspe.app;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import ru.isador.jspe.api.Project;
import ru.isador.jspe.app.core.NewProjectEvent;
import ru.isador.jspe.app.core.RectangleFactory;
import ru.isador.jspe.app.core.SceneCreatedEvent;

/**
 * Контроллер приложения.
 * Пока тут хранится текущий проект, и идет обработка нажатий кнопки мыши.
 */
@ApplicationScoped
public class ApplicationController {

    private RectangleFactory rectangleFactory;
    private EventMulticaster eventMulticaster;
    private TabPane projectTabPane;

    private void onSceneCreated(@Observes SceneCreatedEvent event) {
        projectTabPane = (TabPane) event.scene().lookup("#projectPane");
    }

    @Inject
    public void setEventNewProject(EventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }

    /**
     * Создаёт новый таб для проекта.
     * Также кидает @{@link NewProjectEvent}.
     *
     * @param currentProject новый проект.
     */
    public void setCurrentProject(Project currentProject) {
        eventMulticaster.fire(new NewProjectEvent(currentProject));
        projectTabPane.getTabs().add(newProjectTab(currentProject));
        projectTabPane.getSelectionModel().selectLast();
    }

    private Tab newProjectTab(Project currentProject) {
        Pane projectPane = new Pane();
        projectPane.setId("projectPane_" + currentProject.getName());
        projectPane.setOnMouseDragged(this::onMouseEvent);
        projectPane.setOnMousePressed(this::onMouseEvent);
        projectPane.setOnMouseReleased(this::onMouseEvent);

        Tab projectTab = new Tab(currentProject.getName(), projectPane);
        projectTab.setId("projectTab_" + currentProject.getName());
        return projectTab;
    }

    private void onMouseEvent(MouseEvent e) {
        if (e.getTarget().getClass() != Pane.class) {
            return;
        }

        if (MouseEvent.MOUSE_PRESSED.equals(e.getEventType())) {
            Pane n = (Pane) e.getTarget();
            n.getChildren().add(rectangleFactory.newRectangle(e.getX(), e.getY(), 100.0, 100.0));
        }

        //      if (MouseEvent.MOUSE_DRAGGED.equals(e.getEventType())) {
        //         if (e.getX() < rectangleFactory.getRectangle().getX()) {
        //            rectangleFactory.getRectangle().setX(e.getX());
        //         }
        //         if (e.getY() < rectangleFactory.getRectangle().getY()) {
        //            rectangleFactory.getRectangle().setY(e.getY());
        //         }
        //         rectangleFactory.getRectangle().setWidth(Math.abs(e.getX() - rectangleFactory.getRectangle().getX()));
        //         rectangleFactory.getRectangle().setHeight(Math.abs(e.getY() - rectangleFactory.getRectangle().getY()));
        //      }
    }

    @Inject
    public void setRectangleFactory(RectangleFactory rectangleFactory) {
        this.rectangleFactory = rectangleFactory;
    }
}
