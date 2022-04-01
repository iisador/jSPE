package ru.isador.jspe.api.resource;

public interface OverheadMatrix {

    ResourceRequirement getResourceRequirement();

    void setResourceRequirement(ResourceRequirement resourceRequirement);

    Device getDevice();

    void setDevice(Device device);

    Double getAmountOfService();

    void setAmountOfService(Double amountOfService);
}
