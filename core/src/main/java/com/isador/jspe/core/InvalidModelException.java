package com.isador.jspe.core;

import java.io.Serial;

/** Общий класс исключений для модели. */
public class InvalidModelException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 3701219719560243936L;

    public InvalidModelException(String message) {
        super(message);
    }
}
