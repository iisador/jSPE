package ru.isador.jspe.api;

public class OverheadMatrixElement {

    protected SoftwareResource softwareResource;
    protected Server server;
    protected float amountOfService;

    public SoftwareResource getSoftwareResource() {
        return softwareResource;
    }

    public void setSoftwareResource(SoftwareResource softwareResource) {
        this.softwareResource = softwareResource;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public float getAmountOfService() {
        return amountOfService;
    }

    public void setAmountOfService(float value) {
        this.amountOfService = value;
    }
}
