package ru.isador.jspe.app.components;

/**
 * Дополнительный интерфейс для редактирования таблиц.
 */
@FunctionalInterface
public interface CellValidator {

    ValidatorResult validate(String value);
}
