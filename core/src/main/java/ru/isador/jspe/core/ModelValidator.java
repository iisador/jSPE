package ru.isador.jspe.core;

import java.util.Collection;

public interface ModelValidator {

    Collection<ModelError> validate(SpeModel model);
}
