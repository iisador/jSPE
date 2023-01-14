package ru.isador.jspe.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.inject.Inject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import ru.isador.jspe.app.core.SceneCreatedEvent;

/**
 * Загрузчик fxml приложения.
 */
@ApplicationScoped
public class FxmlLoaderBean {

    private final EventMulticaster eventMulticaster;
    private final FXMLLoader fxmlLoader;
    private final ResourceBundle resourceBundle;
    private Scene scene;
    private SeContainer container;
    private GlobalMouseEventHandler globalMouseEventHandler;

    /**
     * Создание бина.
     *
     * @param eventMulticaster обработчик событий.
     * @param resourceBundle   i18n.
     */
    @Inject
    public FxmlLoaderBean(EventMulticaster eventMulticaster, ResourceBundle resourceBundle) {
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setResources(resourceBundle);
        this.eventMulticaster = eventMulticaster;
        this.resourceBundle = resourceBundle;
    }

    public void setContainer(SeContainer container) {
        this.container = container;
    }

    public void setLocation(URL location) {
        fxmlLoader.setLocation(location);
    }

    @Inject
    public void setGlobalMouseEventHandler(GlobalMouseEventHandler globalMouseEventHandler) {
        this.globalMouseEventHandler = globalMouseEventHandler;
    }

    /**
     * Поехали.
     *
     * @param stage стейдж приложения.
     */
    public void start(Stage stage) throws IOException {
        fxmlLoader.setControllerFactory(param -> container.select(param).get());
        Parent parent = fxmlLoader.load();
        scene = new Scene(parent);
        scene.addEventFilter(MouseEvent.ANY, globalMouseEventHandler);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle(resourceBundle.getString("title"));
        stage.show();
        eventMulticaster.fire(new SceneCreatedEvent(scene));
    }

    @Produces
    public Scene getScene() {
        return scene;
    }
}
