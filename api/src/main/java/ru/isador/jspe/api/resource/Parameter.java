package ru.isador.jspe.api.resource;

import ru.isador.jspe.api.Named;

public interface Parameter extends Named {

    String getType();

    void setType(String type);

    Double getValue();

    void setValue(Double value);
}
