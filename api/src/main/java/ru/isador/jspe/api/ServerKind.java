package ru.isador.jspe.api;

public enum ServerKind {

    SERVER("Server"),
    WORK_UNIT_SERVER("WorkUnitServer");

    private final String value;

    ServerKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }
}
