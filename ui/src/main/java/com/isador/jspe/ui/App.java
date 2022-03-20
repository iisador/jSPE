package com.isador.jspe.ui;

import java.io.IOException;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private SeContainer container;

    @Override
    public void start(Stage stage) throws IOException {
        container = SeContainerInitializer.newInstance().initialize();
        FXMLLoaderBean fxmlLoaderBean = container.select(FXMLLoaderBean.class).get();
        fxmlLoaderBean.setContainer(container);
        fxmlLoaderBean.setLocation(App.class.getResource("primary.fxml"));
        fxmlLoaderBean.start(stage);
    }

    @Override
    public void stop() {
        container.close();
    }
}
