package ru.isador.jspe.ui.resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import ru.isador.jspe.core.Resource;

import static javafx.scene.input.KeyCode.TAB;

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

        resources.getColumns().add(createTableColumn(resourceBundle.getString("resource.column.title"), "title", String.class, Resource::setTitle, ValidatorResult::new));
        resources.getColumns().add(
                createTableColumn(resourceBundle.getString("resource.column.service_unit"), "serviceUnit", String.class, Resource::setServiceUnit, ValidatorResult::new));
        resources.getColumns().add(
                createTableColumn(resourceBundle.getString("resource.column.service_time"), "serviceTime", Double.class, Resource::setServiceTime, value -> {
                    ValidatorResult validatorResult = new ValidatorResult(value);
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

    private interface CellValidator {
        ValidatorResult validate(String value);
    }

    private static class ValidatorResult {
        private final String value;
        private final Collection<String> errors;

        public ValidatorResult(String value) {
            this.value = value;
            errors = new ArrayList<>();
        }

        public ValidatorResult(String value, String error) {
            this(value);
            addError(error);
        }

        public void addError(String error) {
            errors.add(error);
        }

        public Collection<String> getErrors() {
            return errors;
        }

        public String getValue() {
            return value;
        }

        public boolean hasErrors() {
            return !errors.isEmpty();
        }
    }

    private static class EditableCell<S, T> extends TableCell<S, T> {
        private final StringConverter<T> converter;
        private final TextField textField;

        public EditableCell(StringConverter<T> converter, CellValidator validator) {
            this.converter = converter;
            textField = new TextField();
            textField.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case ESCAPE -> {
                        cancelEdit();
                        event.consume();
                    }
                    case ENTER, TAB -> {
                        ValidatorResult validatorResult = validator.validate(textField.getText());
                        if (validatorResult.hasErrors()) {
                            TextField textField = (TextField) event.getSource();

                            setEffect(new DropShadow(BlurType.GAUSSIAN, Color.RED, 7.0, 0.5, 0.0, 0.0));
                            setTooltip(new Tooltip(String.join("; ", validatorResult.getErrors())));
                            Point2D p = textField.localToScene(0.0, 0.0);
                            getTooltip().show(this, p.getX() + textField.getScene().getX() + textField.getScene().getWindow().getX(),
                                    p.getY() + textField.getScene().getY() + textField.getScene().getWindow().getY() + 25);
                            return;
                        }
                        setEffect(null);
                        commitEdit(converter.fromString(textField.getText()));

                        if (event.getCode() == TAB) {
                            int currentIndex = getTableView().getColumns().indexOf(getTableColumn());
                            int columns = getTableView().getColumns().size();
                            if (currentIndex + 1 < columns) {
                                getTableView().edit(getIndex(), getTableView().getColumns().get(currentIndex + 1));
                            }
                        }
                        event.consume();
                    }
                }
            });
        }

        @Override
        public void startEdit() {
            super.startEdit();

            if (isEditing()) {
                textField.setText(converter.toString(getItem()));
                setText(null);
                setGraphic(textField);
                textField.selectAll();
                textField.requestFocus();
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText(converter.toString(getItem()));
            setGraphic(null);
        }

        @Override
        public void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            if (isEmpty()) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    textField.setText(converter.toString(getItem()));
                    setText(null);
                    setGraphic(textField);
                    textField.selectAll();
                    textField.requestFocus();
                } else {
                    setText(converter.toString(getItem()));
                    setGraphic(null);
                }
            }
        }
    }

    private static class CommonStringConverter<T> extends StringConverter<T> {
        private final Class<T> fieldClass;

        public CommonStringConverter(Class<T> fieldClass) {
            this.fieldClass = fieldClass;
        }

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
        @SuppressWarnings("unchecked")
        public T fromString(String string) {
            if (fieldClass == String.class) {
                return (T) string;
            }
            return (T) Double.valueOf(string);
        }
    }
}
