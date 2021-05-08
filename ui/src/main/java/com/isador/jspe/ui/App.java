package com.isador.jspe.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));

        Parent parent = fxmlLoader.load();
        SceneController controller = fxmlLoader.getController();

        Scene scene = new Scene(parent, 800, 600);
        controller.setScene(scene);
        controller.init();

        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("super programma");
        stage.show();
    }
}
