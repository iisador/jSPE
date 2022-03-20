package com.isador.jspe.ui;

import java.util.function.BiConsumer;

import com.isador.jspe.core.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

@ApplicationScoped
public class ResourcesController {

    private TableView<Resource> resources;
    private Button btnRemoveResource;

    @SuppressWarnings("unchecked")
    private void onSceneCreated(@Observes Scene scene) {
        resources = (TableView<Resource>) scene.lookup("#resources");
        btnRemoveResource = (Button) scene.lookup("#btnRemoveResource");

        resources.getColumns().add(createTableColumn("Title", "title", String.class, Resource::setTitle));
        resources.getColumns().add(createTableColumn("Service unit", "serviceUnit", String.class, Resource::setServiceUnit));
        resources.getColumns().add(createTableColumn("Service Time", "serviceTime", Double.class, Resource::setServiceTime));
    }

    @SuppressWarnings("unchecked")
    private <S, T> TableColumn<S, T> createTableColumn(String title, String fieldName, Class<T> fieldClass, BiConsumer<S, T> valueUpdater) {
        TableColumn<S, T> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(fieldName));
        column.setCellFactory(param -> new TextFieldTableCell<>(new StringConverter<>() {
            @Override
            public String toString(Object object) {
                if (object == null) {
                    return null;
                }
                if (fieldClass == Double.class) {
                    return Double.toString((Double) object);
                }
                return String.valueOf(object);
            }

            @Override
            public T fromString(String string) {
                if (fieldClass == String.class) {
                    return (T) string;
                }
                return (T) Double.valueOf(string);
            }
        }));
        column.setOnEditCommit(event -> {
            int row = event.getTablePosition().getRow();
            valueUpdater.accept(event.getTableView().getItems().get(row), event.getNewValue());
        });
        return column;
    }

    public void addResource(MouseEvent event) {
        Resource r = new Resource();
        resources.getItems().add(r);
        resources.edit(resources.getItems().size() - 1, resources.getColumns().get(0));
    }

    public void removeResource(MouseEvent event) {
        resources.getItems().remove(resources.getSelectionModel().getSelectedItem());
        btnRemoveResource.setDisable(resources.getItems().isEmpty());
    }

    public void resourceSelected(MouseEvent event) {
        btnRemoveResource.setDisable(resources.getSelectionModel().getSelectedItem() == null);
    }
}
