package ru.isador.jspe.ui.menu;

import java.util.Optional;
import java.util.ResourceBundle;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import javafx.scene.control.TextInputDialog;
import ru.isador.jspe.api.Project;
import ru.isador.jspe.api.ProjectFactory;
import ru.isador.jspe.ui.ApplicationController;

@ApplicationScoped
public class MenuController {

    private ProjectFactory projectFactory;
    private ApplicationController applicationController;
    private ResourceBundle resourceBundle;

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

    public void newProjectCLicked() {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setHeaderText(resourceBundle.getString("project.new.header"));
        textInputDialog.setGraphic(null);
        textInputDialog.setResizable(true);
        Optional<String> result = textInputDialog.showAndWait();

        if (result.isPresent()) {
            Project project = projectFactory.createProject();
            project.setName(result.get());
            applicationController.setCurrentProject(project);
        }
    }
}
