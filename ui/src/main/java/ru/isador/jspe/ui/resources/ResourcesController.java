package ru.isador.jspe.ui.resources;

import java.util.ResourceBundle;
import java.util.function.BiConsumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.isador.jspe.api.Resource;
import ru.isador.jspe.ui.components.CellValidator;
import ru.isador.jspe.ui.components.CommonStringConverter;
import ru.isador.jspe.ui.components.EditableCell;
import ru.isador.jspe.ui.components.ValidatorResult;

@ApplicationScoped
public class ResourcesController {

    private TableView<Resource> resources;
    private Button btnRemoveResource;
    private ResourceBundle resourceBundle;

    @Inject
    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @SuppressWarnings("unchecked")
    private void onSceneCreated(@Observes Scene scene) {
        resources = (TableView<Resource>) scene.lookup("#resources");
        btnRemoveResource = (Button) scene.lookup("#btnRemoveResource");

        resources.getColumns().add(createTableColumn(resourceBundle.getString("resource.column.title"), "title", String.class, Resource::setTitle, value -> new ValidatorResult()));
        resources.getColumns().add(
                createTableColumn(resourceBundle.getString("resource.column.service_unit"), "serviceUnit", String.class, Resource::setServiceUnit, value -> new ValidatorResult()));
        resources.getColumns().add(
                createTableColumn(resourceBundle.getString("resource.column.service_time"), "serviceTime", Double.class, Resource::setServiceTime, value -> {
                    ValidatorResult validatorResult = new ValidatorResult();
                    try {
                        double val = Double.parseDouble(value);
                        if (val < 0) {
                            validatorResult.addError(resourceBundle.getString("resource.validation.service_time.negative"));
                        }
                    } catch (NumberFormatException ignored) {
                        validatorResult.addError(resourceBundle.getString("resource.validation.service_time.nan"));
                    }
                    return validatorResult;
                }));
    }

    private <S, T> TableColumn<S, T> createTableColumn(String title, String fieldName, Class<T> fieldClass, BiConsumer<S, T> valueUpdater, CellValidator validator) {
        TableColumn<S, T> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(fieldName));
        column.setCellFactory(param -> new EditableCell<>(new CommonStringConverter<>(fieldClass), validator));
        column.setOnEditCommit(event -> {
            int row = event.getTablePosition().getRow();
            valueUpdater.accept(event.getTableView().getItems().get(row), event.getNewValue());
        });

        return column;
    }

    public void addResource() {
        Resource r = new Resource();
        resources.getItems().add(r);
        resources.edit(resources.getItems().size() - 1, resources.getColumns().get(0));
    }

    public void removeResource() {
        resources.getItems().remove(resources.getSelectionModel().getSelectedItem());
        btnRemoveResource.setDisable(resources.getItems().isEmpty());
    }

    public void resourceSelected() {
        btnRemoveResource.setDisable(resources.getSelectionModel().getSelectedItem() == null);
    }
}
