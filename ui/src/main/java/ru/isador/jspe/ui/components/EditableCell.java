package ru.isador.jspe.ui.components;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;

import static javafx.scene.input.KeyCode.TAB;

public class EditableCell<S, T> extends TableCell<S, T> {

    private StringConverter<T> converter;
    private TextField textField;
    private CellValidator validator;

    private final EventHandler<? super KeyEvent> onKeyPressed = event -> {
        switch (event.getCode()) {
            case ESCAPE -> {
                cancelEdit();
                event.consume();
            }
            case ENTER, TAB -> {
                if (validator != null) {
                    ValidatorResult validatorResult = validator.validate(textField.getText());
                    if (validatorResult.hasErrors()) {
                        validatorResult.setValue(textField.getText());
                        showTooltip(String.join("; ", validatorResult.getErrors()));
                        setEffect(new DropShadow(BlurType.GAUSSIAN, Color.RED, 7.0, 0.5, 0.0, 0.0));
                        return;
                    }
                }

                setEffect(null);
                hideTooltip();
                commitEdit(converter.fromString(textField.getText()));

                if (event.getCode() == TAB) {
                    int currentIndex = getCurrentColumnIndex();
                    int columns = getColumnsSize();
                    if (currentIndex + 1 < columns) {
                        getTableView().edit(getIndex(), getColumn(currentIndex + 1));
                    }
                }
                event.consume();
            }
        }
    };

    public EditableCell(StringConverter<T> converter, CellValidator validator) {
        this.converter = converter;
        this.validator = validator;
        textField = new TextField();
        textField.setOnKeyPressed(onKeyPressed);
    }

    public EditableCell(StringConverter<T> converter) {
        this.converter = converter;
        textField = new TextField();
        textField.setOnKeyPressed(onKeyPressed);
    }

    private int getColumnsSize() {
        return getTableView().getColumns().size();
    }

    private int getCurrentColumnIndex() {
        return getTableView().getColumns().indexOf(getTableColumn());
    }

    private TableColumn<S, ?> getColumn(int index) {
        return getTableView().getColumns().get(index);
    }

    private void showTooltip(String text) {
        setTooltip(new Tooltip(text));
        getTooltip().setAutoHide(true);
        Point2D p = textField.localToScene(0.0, 0.0);
        getTooltip().show(this, p.getX() + textField.getScene().getX() + textField.getScene().getWindow().getX(),
                p.getY() + textField.getScene().getY() + textField.getScene().getWindow().getY() + 25);
    }

    private void hideTooltip() {
        if (getTooltip() != null && getTooltip().isShowing()) {
            getTooltip().hide();
            setTooltip(null);
        }
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
