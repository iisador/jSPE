package ru.isador.jspe.api.resource;

import java.util.Collection;

import ru.isador.jspe.api.Named;

public interface ResourceRequirement extends Named {

    Double getUnitsOfService();

    void setUnitsOfService(Double unitsOfService);

    Collection<Parameter> getParameters();

    void addParameter(Parameter parameter);

    void removeParameter(Parameter parameter);
}
