package ru.isador.jspe.app.components;

import javafx.util.StringConverter;

/**
 * Кастомный конвертер значений для таблиц.
 */
public class CommonStringConverter<T> extends StringConverter<T> {
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
