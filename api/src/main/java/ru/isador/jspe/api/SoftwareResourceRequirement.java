package ru.isador.jspe.api;

public class SoftwareResourceRequirement {

    private SoftwareResource softwareResource;
    private float unitsOfService;

    public SoftwareResource getSoftwareResource() {
        return softwareResource;
    }

    public void setSoftwareResource(SoftwareResource softwareResource) {
        this.softwareResource = softwareResource;
    }

    public float getUnitsOfService() {
        return unitsOfService;
    }

    public void setUnitsOfService(float value) {
        this.unitsOfService = value;
    }
}
