package ru.isador.jspe.ui;

import java.io.IOException;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSPEApplication extends javafx.application.Application {
private static final Logger logger = LoggerFactory.getLogger(JSPEApplication.class);

    private SeContainer container;

    @Override
    public void init() {
        container = SeContainerInitializer.newInstance().initialize();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoaderBean fxmlLoaderBean = container.select(FXMLLoaderBean.class).get();
        fxmlLoaderBean.setContainer(container);
        fxmlLoaderBean.setLocation(JSPEApplication.class.getResource("jspe.fxml"));
        fxmlLoaderBean.start(stage);
        logger.info("Application started");
    }

    @Override
    public void stop() {
        container.close();
    }
}
