package ru.isador.jspe.app.menu;

import java.util.Optional;
import java.util.ResourceBundle;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import javafx.scene.control.TextInputDialog;

import ru.isador.jspe.api.Project;
import ru.isador.jspe.api.spi.ProjectFactory;
import ru.isador.jspe.app.ApplicationController;

/**
 * Контроллер меню приложения.
 */
@ApplicationScoped
public class MenuController {

    private ProjectFactory projectFactory;
    private ApplicationController applicationController;
    private ResourceBundle resourceBundle;

    /**
     * Обработка нажатия кнопки "Новый проект".
     */
    public void newProjectClicked() {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setHeaderText(resourceBundle.getString("project.new.header"));
        textInputDialog.setGraphic(null);
        textInputDialog.setResizable(true);
        Optional<String> result = textInputDialog.showAndWait();

        if (result.isPresent()) {
            Project project = projectFactory.create(result.get());
            applicationController.setCurrentProject(project);
        }
    }

    @Inject
    public void setProjectFactory(ProjectFactory projectFactory) {
        this.projectFactory = projectFactory;
    }

    @Inject
    public void setApplicationController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    @Inject
    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }
}
