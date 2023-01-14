package ru.isador.jspe.api;

import java.util.ArrayList;
import java.util.Collection;

public class ComputerResourceRequirement {

    private final Collection<SoftwareResource> softwareResource;
    private final Collection<Facility> facility;

    public ComputerResourceRequirement() {
        softwareResource = new ArrayList<>();
        facility = new ArrayList<>();
    }

    public Collection<SoftwareResource> getSoftwareResource() {
        return softwareResource;
    }

    public Collection<Facility> getFacility() {
        return facility;
    }
}
