package ru.isador.jspe.app.resources;

import java.util.ResourceBundle;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import ru.isador.jspe.app.core.SceneCreatedEvent;

/**
 * Контроллер области ресурсов.
 */
@ApplicationScoped
public class ResourcesController {

    private TableView<String> resources;
    private Button btnRemoveResource;
    private ResourceBundle resourceBundle;

    @Inject
    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @SuppressWarnings("unchecked")
    private void onSceneCreated(@Observes SceneCreatedEvent event) {
        //        resources = (TableView<Resource>) event.scene().lookup("#resources");
        //        btnRemoveResource = (Button) event.scene().lookup("#btnRemoveResource");
        //
        //        resources.getColumns().add(createTableColumn(resourceBundle.getString("resource.column.title"),
        //                "title", String.class, Resource::setTitle, value -> new ValidatorResult()));
        //        resources.getColumns().add(
        //                createTableColumn(resourceBundle.getString("resource.column.service_unit"),
        //                        "serviceUnit", String.class, Resource::setServiceUnit, value -> new ValidatorResult()));
        //        resources.getColumns().add(
        //                createTableColumn(resourceBundle.getString("resource.column.service_time"),
        //                        "serviceTime", Double.class, Resource::setServiceTime, value -> {
        //                            ValidatorResult validatorResult = new ValidatorResult();
        //                            try {
        //                                double val = Double.parseDouble(value);
        //                                if (val < 0) {
        //                                    validatorResult.addError(resourceBundle.getString(
        //                                            "resource.validation.service_time.negative"));
        //                                }
        //                            } catch (NumberFormatException ignored) {
        //                                validatorResult.addError(resourceBundle.getString(
        //                                        "resource.validation.service_time.nan"));
        //                            }
        //                            return validatorResult;
        //                        }));
    }

    //    private <S, T> TableColumn<S, T> createTableColumn(String title, String fieldName, Class<T> fieldClass,
    //            BiConsumer<S, T> valueUpdater, CellValidator validator) {
    //        TableColumn<S, T> column = new TableColumn<>(title);
    //        column.setCellValueFactory(new PropertyValueFactory<>(fieldName));
    //        column.setCellFactory(param -> new EditableCell<>(new CommonStringConverter<>(fieldClass), validator));
    //        column.setOnEditCommit(event -> {
    //            int row = event.getTablePosition().getRow();
    //            valueUpdater.accept(event.getTableView().getItems().get(row), event.getNewValue());
    //        });
    //
    //        return column;
    //    }

    /**
     * Добавить ресурс.
     */
    public void addResource() {
        //        Resource r = new Resource();
        //        resources.getItems().add(r);
        //        resources.edit(resources.getItems().size() - 1, resources.getColumns().get(0));
    }

    public void removeResource() {
        //        resources.getItems().remove(resources.getSelectionModel().getSelectedItem());
        //        btnRemoveResource.setDisable(resources.getItems().isEmpty());
    }

    public void resourceSelected() {
        //        btnRemoveResource.setDisable(resources.getSelectionModel().getSelectedItem() == null);
    }
}
