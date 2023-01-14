package ru.isador.jspe.app;

import java.io.IOException;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Стартовая точка приложения JavaFx приложения.
 */
public class JspeApplication extends Application {

    private static final Logger logger = LoggerFactory.getLogger(JspeApplication.class);
    private static final String FX_XML_NAME = "jspe.fxml";

    private SeContainer container;

    /**
     * Инициализация компонентов приложения.
     * На этом этапе происходит инициализация компонентов приложения:
     * se контейнера;
     */
    @Override
    public void init() {
        container = SeContainerInitializer.newInstance().initialize();
    }

    /**
     * Запуск приложения.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FxmlLoaderBean fxmlLoaderBean = container.select(FxmlLoaderBean.class).get();
        fxmlLoaderBean.setContainer(container);
        fxmlLoaderBean.setLocation(JspeApplication.class.getResource(FX_XML_NAME));
        fxmlLoaderBean.start(stage);
        logger.info("Application started");
    }

    /**
     * Всякие операции после закрытия приложения.
     */
    @Override
    public void stop() {
        container.close();
    }
}
