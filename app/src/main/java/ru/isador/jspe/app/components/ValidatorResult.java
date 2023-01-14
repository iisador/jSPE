package ru.isador.jspe.app.components;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Результат валидации.
 */
public class ValidatorResult {

    private final Collection<String> errors;
    private String value;

    public ValidatorResult() {
        errors = new ArrayList<>();
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

    void setValue(String value) {
        this.value = value;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
