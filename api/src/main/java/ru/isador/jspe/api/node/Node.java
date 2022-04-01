package ru.isador.jspe.api.node;

import java.util.Collection;

import ru.isador.jspe.api.Named;
import ru.isador.jspe.api.resource.ResourceRequirement;

public interface Node extends Named {

    Double getProbability();

    void setProbability(Double probability);

    String getLocation();

    void setLocation(String location);

    Collection<ResourceRequirement> getResourceRequirements();

    void addResourceRequirement(ResourceRequirement resourceRequirement);

    void removeResourceRequirement(ResourceRequirement resourceRequirement);
}
