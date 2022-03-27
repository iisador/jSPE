package ru.isador.jspe.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.inject.Inject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

@ApplicationScoped
public class FXMLLoaderBean {

    private final Event<Scene> event;
    private final FXMLLoader fxmlLoader;
    private final ResourceBundle resourceBundle;
    private Scene scene;
    private SeContainer container;

    @Inject
    public FXMLLoaderBean(Event<Scene> event, ResourceBundle resourceBundle) {
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setResources(resourceBundle);
        this.event = event;
        this.resourceBundle = resourceBundle;
    }

    public void setContainer(SeContainer container) {
        this.container = container;
    }

    public void setLocation(URL location) {
        fxmlLoader.setLocation(location);
    }

    public void start(Stage stage) throws IOException {
        fxmlLoader.setControllerFactory(param -> container.select(param).get());

        Parent parent = fxmlLoader.load();

        scene = new Scene(parent);

        scene.addEventFilter(MouseEvent.ANY, new GlobalMouseEventHandler());
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle(resourceBundle.getString("title"));
        stage.show();
        event.fire(scene);
    }

    @Produces
    public Scene getScene() {
        return scene;
    }
}
