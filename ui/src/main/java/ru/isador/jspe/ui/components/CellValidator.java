package ru.isador.jspe.ui.components;

@FunctionalInterface
public interface CellValidator {

    ValidatorResult validate(String value);
}
